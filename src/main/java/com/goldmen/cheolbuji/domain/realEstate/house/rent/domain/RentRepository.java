package com.goldmen.cheolbuji.domain.realEstate.house.rent.domain;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent,Integer> {
    Optional<Rent> findByBuildingAndAreaAndFloor(Building building,double area,int floor);

    Optional<Rent> findFirstByBuildingAndAreaAndFloor(Building building,double area,int floor);
}
