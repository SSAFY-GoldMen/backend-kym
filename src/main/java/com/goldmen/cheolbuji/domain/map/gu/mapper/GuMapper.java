package com.goldmen.cheolbuji.domain.map.gu.mapper;


import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import org.springframework.stereotype.Component;

@Component
public class GuMapper {
    public Gu toEntity(String guCode, String guName){
        return Gu.builder().code(guCode).name(guName).build();
    }
}
