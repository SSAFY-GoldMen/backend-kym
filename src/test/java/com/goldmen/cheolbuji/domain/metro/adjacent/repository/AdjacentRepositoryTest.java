package com.goldmen.cheolbuji.domain.metro.adjacent.repository;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.domain.DongRepository;
import com.goldmen.cheolbuji.domain.map.dong.fixture.DongFixture;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.domain.GuRepository;
import com.goldmen.cheolbuji.domain.map.gu.fixture.GuFixture;
import com.goldmen.cheolbuji.domain.metro.adjacent.fixture.AdjacentFixture;
import com.goldmen.cheolbuji.domain.metro.line.domain.Line;
import com.goldmen.cheolbuji.domain.metro.line.domain.LineRepository;
import com.goldmen.cheolbuji.domain.metro.line.fixture.LineFixture;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import com.goldmen.cheolbuji.domain.metro.station.domain.StationRepository;
import com.goldmen.cheolbuji.domain.metro.station.fixture.StationFixture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@DataJpaTest
class AdjacentRepositoryTest {
    @Autowired
    private AdjacentRepository adjacentRepository;
    @Autowired
    private DongRepository dongRepository;
    @Autowired
    private GuRepository guRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private LineRepository lineRepository;

    @DisplayName("저장 시 두 스테이션에서 나와야 함")
    @Test
    void saveTest(){
        Gu gu = guRepository.save(GuFixture.GANGNAMGU.create());
        Dong dong = dongRepository.save(DongFixture.YUKSAMDONG.create(gu));
        Line line = lineRepository.save(LineFixture.LINE_2.create());
        Station stationA = stationRepository.save(StationFixture.GANGNAM.create(dong));
        Station stationB = stationRepository.save(StationFixture.YUKSAM.create(dong));
        adjacentRepository.save(AdjacentFixture.SIXTY.create(stationA,stationB,line));
        adjacentRepository.save(AdjacentFixture.SIXTY.create(stationB,stationA,line));

        List<Adjacent> adjacentList = adjacentRepository.findAll();
        assertEquals(2,adjacentList.size());

        assertEquals(stationA.getId(),adjacentList.get(0).getStationA().getId());
        assertEquals(stationB.getId(),adjacentList.get(0).getStationB().getId());
        assertEquals(stationB.getId(),adjacentList.get(1).getStationA().getId());
        assertEquals(stationA.getId(),adjacentList.get(1).getStationB().getId());
    }
}