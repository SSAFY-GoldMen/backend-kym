package com.goldmen.cheolbuji.domain.metro.line.mapper;

import com.goldmen.cheolbuji.domain.metro.line.domain.Line;
import org.springframework.stereotype.Component;

@Component
public class LineMapper {
    public Line toEntity(String name){
        return Line.builder().name(name).build();
    }
}
