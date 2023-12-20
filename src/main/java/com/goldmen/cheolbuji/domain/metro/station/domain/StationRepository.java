package com.goldmen.cheolbuji.domain.metro.station.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station,Integer> {
    Optional<Station> findByName(String name);
}
