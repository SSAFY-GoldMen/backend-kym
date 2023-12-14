package com.goldmen.cheolbuji.domain.realEstate.purchase;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@Getter
public class Purchase {
    @Column(nullable = false)
    private double area;

    @Column(nullable = false)
    private int floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUILDING_ID")
    private Building building;

    //보증금
    private int price; // 단위: 만원

    public Purchase(double area, int floor, Building building, int price){
        this.area = area;
        this.floor = floor;
        this.building = building;
        this.price = price;
    }
}
