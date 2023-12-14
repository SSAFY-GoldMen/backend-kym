package com.goldmen.cheolbuji.domain.realEstate.purchase.walse.domain;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Walse extends Purchase {
    @Id
    @Column(name = "WALSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int rent;   //만원

    @Builder
    public Walse(double area, int floor, Building building, int price,int rent) {
        super(area, floor, building, price);
        this.rent = rent;
    }
}
