package com.goldmen.cheolbuji.domain.metro.line.service;

import com.goldmen.cheolbuji.domain.metro.line.domain.Line;
import com.goldmen.cheolbuji.domain.metro.line.domain.LineRepository;
import com.goldmen.cheolbuji.domain.metro.line.exception.LineNotFoundException;
import com.goldmen.cheolbuji.domain.metro.line.mapper.LineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LineService {
    private final LineRepository lineRepository;
    private final LineMapper lineMappero;

    @Transactional
    public Line save(String name){
        return lineRepository.save(lineMappero.toEntity(name));
    }

    public Line findByName(String name){
        return lineRepository.findByName(name).orElseThrow(LineNotFoundException::new);
    }
}
