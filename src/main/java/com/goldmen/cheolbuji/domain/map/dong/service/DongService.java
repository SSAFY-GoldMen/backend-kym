package com.goldmen.cheolbuji.domain.map.dong.service;

import com.goldmen.cheolbuji.client.seoulOpenData.rent.service.SeoulOpenDataRentService;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.domain.DongRepository;
import com.goldmen.cheolbuji.domain.map.dong.exception.DongNotFoundException;
import com.goldmen.cheolbuji.domain.map.dong.mapper.DongMapper;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DongService {
    private final DongRepository dongRepository;
    private final DongMapper dongMapper;

    public Dong findByCode(String code){
        return dongRepository.findByCode(code).orElseThrow(DongNotFoundException::new);
    }

    @Transactional
    public Dong save(String dongCode, String dongName, Gu gu) {
        return dongRepository.save(dongMapper.toEntity(dongCode,dongName,gu));
    }
}
