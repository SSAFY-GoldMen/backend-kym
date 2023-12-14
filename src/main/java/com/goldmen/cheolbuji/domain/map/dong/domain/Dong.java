package com.goldmen.cheolbuji.domain.map.dong.domain;

import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Dong {
    @Id
    @Column(name = "DONG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DONG_NAME", nullable = false, length = 10)
    private String name;

    @Column(name = "DONG_CODE", nullable = false, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GU_ID")
    private Gu gu;

    @OneToMany(mappedBy = "dong")
    private final List<Station> stationList = new ArrayList<>();

    @Builder
    public Dong(String name, String code,Gu gu){
        this.name = name;
        this.code = code;
        addRelatedByGu(gu);
    }

    private void addRelatedByGu(Gu gu) {
        this.gu = gu;
        gu.getDongList().add(this);
    }
}
