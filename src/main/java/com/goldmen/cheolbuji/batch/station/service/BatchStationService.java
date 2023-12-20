package com.goldmen.cheolbuji.batch.station.service;

import com.goldmen.cheolbuji.client.kakao.service.KakaoMapService;
import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.station.service.SeoulOpenDataStationService;
import com.goldmen.cheolbuji.client.seoulOpenData.station.vo.SeoulOpenDataStation;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.exception.DongNotFoundException;
import com.goldmen.cheolbuji.domain.map.dong.service.DongService;
import com.goldmen.cheolbuji.domain.metro.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class BatchStationService {

    private final SeoulOpenDataStationService seoulOpenDataStationService;
    private final StationService stationService;
    private final KakaoMapService kakaoMapService;
    private final DongService dongService;

    public void initiate() throws IOException {
        SeoulOpenDataResponse<SeoulOpenDataStation> response = seoulOpenDataStationService.loadFile();
        response.seoulOpenDataList().forEach(station -> {
            kakaoMapService.findLocation(station.stationName()).ifPresent(location -> {
                Dong dong = null;
                try{
                    dong = dongService.findByNameAndGuName(location.dongName(),location.guName());
                }catch (DongNotFoundException ignored){}
                stationService.save(station.stationName(),dong,location.coordinate());
            });
        });
    }
}
