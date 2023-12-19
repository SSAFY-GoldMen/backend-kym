package com.goldmen.cheolbuji.domain.metro.station.domain;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.metro.adjacent.repository.Adjacent;
import com.goldmen.cheolbuji.domain.global.Coordinate;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Station {
    @Id
    @Column(name = "STATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STATION_NAME", nullable = false, length = 10)
    private String name;

    @Embedded
    private Coordinate coordinate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DONG_ID")
    private Dong dong;

    @OneToMany(mappedBy = "stationA")
    private final List<Adjacent> adjacentAList = new ArrayList<>();

    @OneToMany(mappedBy = "stationB")
    private final List<Adjacent> adjacentBList = new ArrayList<>();

    @Builder
    public Station(String name,Dong dong, Coordinate coordinate){
        this.name = name;
        this.coordinate = coordinate;
        addRelated(dong);
    }

    public List<Adjacent> getAdjacentList(){
        Set<Adjacent> adjacentList = new HashSet<>();
        adjacentList.addAll(this.adjacentAList);
        adjacentList.addAll(this.adjacentBList);
        return adjacentList.stream().toList();
    }

    private void addRelated(Dong dong){
        this.dong = dong;
        dong.getStationList().add(this);
    }
}
