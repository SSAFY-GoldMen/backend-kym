package com.goldmen.cheolbuji.domain.metro.adjacent.fixture;

import com.goldmen.cheolbuji.domain.metro.adjacent.repository.Adjacent;
import com.goldmen.cheolbuji.domain.metro.line.domain.Line;
import com.goldmen.cheolbuji.domain.metro.line.fixture.LineFixture;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import com.goldmen.cheolbuji.domain.metro.station.fixture.StationFixture;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

public enum AdjacentFixture {
    SIXTY(60);

    private final int time;

    AdjacentFixture(int time) {
        this.time = time;
    }

    public Adjacent create(){
        return Adjacent.builder()
                .time(time)
                .stationA(StationFixture.GANGNAM.create())
                .stationB(StationFixture.YUKSAM.create())
                .line(LineFixture.LINE_2.create())
                .build();
    }

    public Adjacent create(Station stationA, Station stationB, Line line){
        return Adjacent.builder()
                .time(time)
                .stationA(stationA)
                .stationB(stationB)
                .line(line)
                .build();
    }
}
