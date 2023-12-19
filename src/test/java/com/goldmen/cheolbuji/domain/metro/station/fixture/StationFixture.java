package com.goldmen.cheolbuji.domain.metro.station.fixture;

import com.goldmen.cheolbuji.domain.global.Coordinate;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.fixture.DongFixture;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;

public enum StationFixture {
    GANGNAM("강남역",37.49808633653005,127.02800140627488),
    YUKSAM("역삼역",37.49808633653012,127.02800140627401);

    private final String name;
    private final double lat;
    private final double lng;

    StationFixture(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public Station create(){
        return Station.builder()
                .dong(DongFixture.GANGNAMDONG.create())
                .name(name)
                .coordinate(new Coordinate(lat,lng)).build();
    }

    public Station create(Dong dong){
        return Station.builder()
                .dong(dong)
                .name(name).coordinate(new Coordinate(lat,lng)).build();
    }
}
