package com.goldmen.cheolbuji.domain.metro.adjacent.repository;

import com.goldmen.cheolbuji.domain.metro.line.domain.Line;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Adjacent {
    @Id
    @Column(name = "ADJACENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ADJACENT_TIME", nullable = false)
    private int time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATION_A_ID")
    private Station stationA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATION_B_ID")
    private Station stationB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LINE_ID")
    private Line line;

    @Builder
    private Adjacent(int time, Station stationA, Station stationB,Line line){
        this.time = time;
        this.stationA = stationA;
        this.stationB = stationB;
        stationA.getAdjacentAList().add(this);
        stationB.getAdjacentBList().add(this);
        addRelated(line);
    }

    private void addRelated(Line line) {
        this.line = line;
        line.getAdjacentList().add(this);
    }
}
