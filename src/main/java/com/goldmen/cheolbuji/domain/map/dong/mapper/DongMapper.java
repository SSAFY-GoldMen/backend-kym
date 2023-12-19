package com.goldmen.cheolbuji.domain.map.dong.mapper;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import org.springframework.stereotype.Component;

@Component
public class DongMapper {
    public Dong toEntity(String dongCode, String dongName, Gu gu){
        return Dong.builder().code(dongCode).name(dongName).gu(gu).build();
    }
}
