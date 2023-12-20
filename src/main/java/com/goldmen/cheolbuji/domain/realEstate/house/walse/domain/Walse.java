package com.goldmen.cheolbuji.domain.realEstate.house.walse.domain;

import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Walse {
    @Id
    @Column(name = "WALSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "WALSE_PRICE")
    private int price;

    @Column(name = "WALSE_MONTHLY_PRICE")
    private int monthlyPrice;   //만원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RENT_ID")
    private Rent rent;

    @Builder
    public Walse(Rent rent, int price, int monthlyPrice) {
        this.price = price;
        this.monthlyPrice = monthlyPrice;
        addRelatedByRent(rent);
    }

    private void addRelatedByRent(Rent rent){
        this.rent = rent;
        rent.getWalseList().add(this);
    }
}
