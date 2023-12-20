package com.goldmen.cheolbuji.domain.map.dong.service;

import com.goldmen.cheolbuji.client.seoulOpenData.rent.service.SeoulOpenDataRentService;
import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.domain.DongRepository;
import com.goldmen.cheolbuji.domain.map.dong.exception.DongNotFoundException;
import com.goldmen.cheolbuji.domain.map.dong.mapper.DongMapper;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DongService {
    private final DongRepository dongRepository;
    private final DongMapper dongMapper;

    public Dong findByCode(String code){
        return dongRepository.findFirstByCode(code).orElseThrow(DongNotFoundException::new);
    }

    public Dong findByNameAndGuName(String dongName, String guName){
        return dongRepository.findFirstByNameAndGu_Name(dongName,guName).orElseThrow(DongNotFoundException::new);
    }

    @Transactional
    public Dong save(String dongCode, String dongName, Gu gu) {
        return dongRepository.save(dongMapper.toEntity(dongCode,dongName,gu));
    }
}
