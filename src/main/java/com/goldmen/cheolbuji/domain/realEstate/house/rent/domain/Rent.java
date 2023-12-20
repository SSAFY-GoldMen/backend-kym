package com.goldmen.cheolbuji.domain.realEstate.house.rent.domain;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.house.jeonse.domain.Jeonse;
import com.goldmen.cheolbuji.domain.realEstate.house.walse.domain.Walse;
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
public class Rent {

    @Id
    @Column(name = "RENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double area;

    @Column(nullable = false)
    private int floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUILDING_ID")
    private Building building;

    @OneToMany(mappedBy = "rent")
    private final List<Walse> walseList = new ArrayList<>();

    @OneToMany(mappedBy = "rent")
    private final List<Jeonse> jeonseList = new ArrayList<>();

    @Builder
    public Rent(double area, int floor, Building building){
        this.area = area;
        this.floor = floor;
        addRelatedByBuilding(building);
    }

    private void addRelatedByBuilding(Building building){
        this.building = building;
        building.getRentList().add(this);
    }
}
