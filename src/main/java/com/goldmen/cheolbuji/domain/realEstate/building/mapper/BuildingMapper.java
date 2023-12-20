package com.goldmen.cheolbuji.domain.realEstate.building.mapper;

import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.global.Address;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {
    public Building toEntity(SeoulOpenDataRent rent, KakaoLocation location, Dong dong){
        return Building.builder().name(rent.buildingName())
                .dong(dong)
                .constructionYear(rent.constructorYear())
                .type(rent.buildingType())
                .address(new Address(rent.bonNum(), rent.buNum(),location.coordinate()))
                .build();
    }
}
