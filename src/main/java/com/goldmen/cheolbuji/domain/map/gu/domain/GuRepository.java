package com.goldmen.cheolbuji.domain.map.gu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuRepository extends JpaRepository<Gu,Integer> {
    Optional<Gu> findByCode(String code);
}
