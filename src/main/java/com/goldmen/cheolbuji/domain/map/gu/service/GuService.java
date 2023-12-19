package com.goldmen.cheolbuji.domain.map.gu.service;

import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.domain.GuRepository;
import com.goldmen.cheolbuji.domain.map.gu.exception.GuNotFoundException;
import com.goldmen.cheolbuji.domain.map.gu.mapper.GuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GuService {
    private final GuRepository guRepository;
    private final GuMapper guMapper;

    public Gu findByCode(String code){
        return guRepository.findByCode(code).orElseThrow(GuNotFoundException::new);
    }

    @Transactional
    public Gu save(String guCode, String guName) {
        return guRepository.findByCode(guCode).orElseGet(()->guRepository.save(guMapper.toEntity(guCode,guName)));
    }
}
