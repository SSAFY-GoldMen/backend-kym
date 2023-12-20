package com.goldmen.cheolbuji.domain.metro.station.service;

import com.goldmen.cheolbuji.domain.global.Coordinate;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import com.goldmen.cheolbuji.domain.metro.station.domain.StationRepository;
import com.goldmen.cheolbuji.domain.metro.station.exception.StationNotFoundException;
import com.goldmen.cheolbuji.domain.metro.station.mapper.StationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public Station save(String name, Dong dong, Coordinate coordinate){
        return stationRepository.save(stationMapper.toEntity(name,dong,coordinate));
    }

    @Transactional
    public Station findByName(String name){
        return stationRepository.findByName(name).orElseThrow(StationNotFoundException::new);
    }
}
