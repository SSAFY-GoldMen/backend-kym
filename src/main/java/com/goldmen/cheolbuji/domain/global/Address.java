package com.goldmen.cheolbuji.domain.global;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class Address {
    @Column(nullable = false)
    private String bonNum;

    @Column(nullable = false)
    private String buNum;

    @Embedded
    private Coordinate coordinate;

    public Address(String bonNum,String buNum, Coordinate coordinate){
        this.bonNum = bonNum;
        this.buNum = buNum;
        this.coordinate = coordinate;
    }
}
