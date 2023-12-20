package com.goldmen.cheolbuji.domain.realEstate.building.domain;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.global.Address;
import com.goldmen.cheolbuji.domain.global.Coordinate;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
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
public class Building {
    @Id
    @Column(name = "BUILDING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BUILDING_NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "BUILDING_TYPE", nullable = false, length = 15)
    private BuildingType type;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private int constructionYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DONG_ID")
    private Dong dong;

    @OneToMany(mappedBy = "building")
    private final List<Rent> rentList = new ArrayList<>();

    @Builder
    public Building(String name,
                    String type,
                    Address address,
                    int constructionYear,
                    Dong dong) {
        this.name = name;
        this.type = BuildingType.valueOf(type);
        this.address = address;
        this.constructionYear = constructionYear;
        addRelatedByDong(dong);
    }

    private void addRelatedByDong(Dong dong){
        this.dong = dong;
        dong.getBuildingList().add(this);
    }
}
