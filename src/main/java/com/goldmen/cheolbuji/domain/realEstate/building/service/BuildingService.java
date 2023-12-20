package com.goldmen.cheolbuji.domain.realEstate.building.service;

import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.BuildingRepository;
import com.goldmen.cheolbuji.domain.realEstate.building.mapper.BuildingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;

    public Building save(SeoulOpenDataRent rent, KakaoLocation location, Dong dong){
        return buildingRepository.save(buildingMapper.toEntity(rent,location,dong));
    }

    public Optional<Building> findByDongAndRent(Dong dong, SeoulOpenDataRent rent){
        return buildingRepository.findFirstByDongAndAddressBonNumAndAddressBuNum(dong,rent.bonNum(), rent.buNum());
    }
}
