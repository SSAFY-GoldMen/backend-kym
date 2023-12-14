package com.goldmen.cheolbuji.domain.metro.line.domain;

import com.goldmen.cheolbuji.domain.metro.adjacent.repository.Adjacent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Line {
    @Id
    @Column(name = "LINE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LINE_NAME", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "line")
    private final List<Adjacent> adjacentList = new ArrayList<>();

    @Builder
    public Line(String name) {
        this.name = name;
    }
}

