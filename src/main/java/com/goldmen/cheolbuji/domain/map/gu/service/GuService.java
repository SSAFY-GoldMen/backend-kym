package com.goldmen.cheolbuji.domain.map.gu.service;

import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.domain.GuRepository;
import com.goldmen.cheolbuji.domain.map.gu.exception.GuNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GuService {
    private GuRepository guRepository;

    public Gu save(Gu gu){
        return guRepository.save(gu);
    }

    public Gu findByCode(String code){
        return guRepository.findByCode(code).orElseThrow(GuNotFoundException::new);
    }
}
