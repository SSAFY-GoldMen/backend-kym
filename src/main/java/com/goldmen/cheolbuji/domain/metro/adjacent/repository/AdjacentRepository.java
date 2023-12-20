package com.goldmen.cheolbuji.domain.metro.adjacent.repository;

import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdjacentRepository extends JpaRepository<Adjacent,Integer> {

    List<Adjacent> findAllByStationAOrStationB(Station stationA,Station stationB);
}
