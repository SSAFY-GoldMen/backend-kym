package com.goldmen.cheolbuji.domain.global;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Coordinate {
    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    public Coordinate(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }
}