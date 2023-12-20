package com.goldmen.cheolbuji.domain.metro.adjacent.service;

import com.goldmen.cheolbuji.domain.metro.adjacent.exception.AdjacentNotFoundException;
import com.goldmen.cheolbuji.domain.metro.adjacent.repository.Adjacent;
import com.goldmen.cheolbuji.domain.metro.adjacent.repository.AdjacentRepository;
import com.goldmen.cheolbuji.domain.metro.station.domain.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AdjacentService {
    private final AdjacentRepository adjacentRepository;

    public Adjacent save(Adjacent adjacent){
        return adjacentRepository.save(adjacent);
    }

    public List<Adjacent> findAllByStation(Station station){
        List<Adjacent> adjacentList  = adjacentRepository.findAllByStationAOrStationB(station,station);
        if(adjacentList.isEmpty()) throw new AdjacentNotFoundException();
        return adjacentList;
    }
}
