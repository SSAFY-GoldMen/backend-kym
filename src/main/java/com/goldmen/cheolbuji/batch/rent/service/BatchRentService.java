package com.goldmen.cheolbuji.batch.rent.service;

import com.goldmen.cheolbuji.client.kakao.dto.request.KakaoLocationRequest;
import com.goldmen.cheolbuji.client.kakao.service.KakaoMapService;
import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.service.SeoulOpenDataRentService;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.service.DongService;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.building.service.BuildingService;
import com.goldmen.cheolbuji.domain.realEstate.house.jeonse.service.JeonseService;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.service.RentService;
import com.goldmen.cheolbuji.domain.realEstate.house.walse.service.WalseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BatchRentService {
    private final SeoulOpenDataRentService seoulOpenDataRentService;
    private final BuildingService buildingService;
    private final DongService dongService;
    private final KakaoMapService kakaoMapService;

    private final RentService rentService;
    private final JeonseService jeonseService;
    private final WalseService walseService;

    public void initiate() throws IOException {
        List<SeoulOpenDataRent> seoulOpenDataRentList = seoulOpenDataRentService.filter(seoulOpenDataRentService.loadFile().seoulOpenDataList());
        double totalSize = 1000;
        int nowProgress = 0;
        double size = 0;
        for(SeoulOpenDataRent seoulOpenDataRent : seoulOpenDataRentList.subList(0,1000)) {
            saveRentData(seoulOpenDataRent);
            if((size++/totalSize)*100 >= nowProgress){
                log.info((int)((size/totalSize)*100) +"%");
                nowProgress++;
            }
        }
    }

    private void saveRentData(SeoulOpenDataRent seoulOpenDataRent){
        try {
            Dong dong = dongService.findByNameAndGuName(seoulOpenDataRent.dongName(), seoulOpenDataRent.guName());
            Building building = buildingService.findByDongAndRent(dong,seoulOpenDataRent).orElseGet(()->{
                KakaoLocation kakaoLocation = kakaoMapService.findLocation(KakaoLocationRequest.from(seoulOpenDataRent)).orElseThrow();
                return buildingService.save(seoulOpenDataRent,kakaoLocation,dong);
            });
            Rent rent = rentService.save(building,seoulOpenDataRent.area(), seoulOpenDataRent.floor());

            if(seoulOpenDataRent.rentType().equals("전세")){
                jeonseService.save(rent,seoulOpenDataRent.price());
            }else if(seoulOpenDataRent.rentType().equals("월세")){
                walseService.save(rent,seoulOpenDataRent.price(),seoulOpenDataRent.rent());
            }
        } catch (Exception ignored) {}
    }
}
