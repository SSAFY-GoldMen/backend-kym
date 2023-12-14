package com.goldmen.cheolbuji.domain.realEstate.building.domain;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.global.Address;
import com.goldmen.cheolbuji.domain.global.Position;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public Building(String name,
                    BuildingType type,
                    Address address,
                    int constructionYear,
                    Dong dong) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.constructionYear = constructionYear;
        this.dong = dong;
    }

    @Builder(builderMethodName = "fromPositionBuilder")
    public Building(String name,
                    BuildingType type,
                    String bonNum,
                    String buNum,
                    int constructionYear,
                    Position position,
                    Dong dong) {
        this(name,type, new Address(bonNum,buNum,position),constructionYear,dong);
    }

}
