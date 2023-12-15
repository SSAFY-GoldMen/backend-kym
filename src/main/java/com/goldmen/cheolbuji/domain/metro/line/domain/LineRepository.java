package com.goldmen.cheolbuji.domain.metro.line.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LineRepository extends JpaRepository<Line,Integer> {
    Optional<Line> findByName(String name);
}
