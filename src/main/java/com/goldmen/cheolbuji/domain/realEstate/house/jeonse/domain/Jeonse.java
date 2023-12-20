package com.goldmen.cheolbuji.domain.realEstate.house.jeonse.domain;

import com.goldmen.cheolbuji.domain.realEstate.building.domain.Building;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Jeonse{
    @Id
    @Column(name = "JEONSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RENT_ID")
    private Rent rent;

    private int price;

    @Builder
    public Jeonse(Rent rent, int price) {
        this.price = price;
        addRelatedByRent(rent);
    }

    private void addRelatedByRent(Rent rent){
        this.rent = rent;
        rent.getJeonseList().add(this);
    }
}
