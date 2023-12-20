package com.goldmen.cheolbuji.domain.realEstate.house.rent.service;

import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.RentRepository;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.exception.RentNotFoundException;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.mapper.RentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RentService {
    private final RentRepository rentRepository;
    private final RentMapper rentMapper;

    public Rent save(Building building,double area, int floor) {
        return rentRepository.findByBuildingAndAreaAndFloor(building,area,floor)
                .orElseGet(()->rentRepository.save(rentMapper.toEntity(building,area,floor)));
    }

    public Rent findByBuildingAndAreaAndFloor(Building building,double area, int floor) {
        return rentRepository.findFirstByBuildingAndAreaAndFloor(building,area,floor).orElseThrow(RentNotFoundException::new);
    }
}
