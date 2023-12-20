package com.goldmen.cheolbuji.domain.realEstate.house.rent.domain;

import com.goldmen.cheolbuji.domain.realEstate.house.jeonse.domain.Jeonse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Jeonse,Integer> {
}
