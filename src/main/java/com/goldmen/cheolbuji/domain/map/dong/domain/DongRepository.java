package com.goldmen.cheolbuji.domain.map.dong.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DongRepository extends JpaRepository<Dong,Integer> {
    Optional<Dong> findByCode(String code);
}
