package com.goldmen.cheolbuji.domain.global;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Position {
    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    public Position(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }
}