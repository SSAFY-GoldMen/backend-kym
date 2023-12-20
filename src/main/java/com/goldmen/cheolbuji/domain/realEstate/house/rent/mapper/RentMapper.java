package com.goldmen.cheolbuji.domain.realEstate.house.rent.mapper;

import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {
    public Rent toEntity(Building building,double area, int floor){
        return Rent.builder().building(building).area(area).floor(floor).build();
    }
}
