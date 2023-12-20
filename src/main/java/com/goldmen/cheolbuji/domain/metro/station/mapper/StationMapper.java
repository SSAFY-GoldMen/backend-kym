package com.goldmen.cheolbuji.domain.metro.station.mapper;

import com.goldmen.cheolbuji.domain.global.Coordinate;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import org.springframework.stereotype.Component;

@Component
public class StationMapper {
    public Station toEntity(String name, Dong dong, Coordinate coordinate){
        return Station.builder().coordinate(coordinate).dong(dong).name(name).build();
    }
}
