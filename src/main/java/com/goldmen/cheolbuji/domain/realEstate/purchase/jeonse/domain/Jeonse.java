package com.goldmen.cheolbuji.domain.realEstate.purchase.jeonse.domain;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Jeonse extends Purchase {
    @Id
    @Column(name = "JEONSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Builder
    public Jeonse(double area, int floor, Building building, int price) {
        super(area, floor, building, price);
    }
}
