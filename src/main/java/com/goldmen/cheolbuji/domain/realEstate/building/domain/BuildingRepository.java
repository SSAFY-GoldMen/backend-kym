package com.goldmen.cheolbuji.domain.realEstate.building.domain;

import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building,Integer> {
    @Query(value = "select b from Building b " +
            "where b.dong.id = :#{#dong.id} " +
            "and b.address.bonNum = :#{#rent.bonNum()} " +
            "and b.address.buNum = :#{#rent.buNum()} " +
            "and b.type = :#{#rent.buildingType()} " +
            "and b.name = :#{#rent.buildingName()}")
    Optional<Building> findFirstByOption(@Param("rent") SeoulOpenDataRent rent, @Param("dong") Dong dong);

    Optional<Building> findFirstByDongAndAddressBonNumAndAddressBuNum(Dong dong,String bonNum, String buNum);
}
