package com.goldmen.cheolbuji.domain.map.dong.service;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.domain.DongRepository;
import com.goldmen.cheolbuji.domain.map.dong.exception.DongNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DongService {
    private final DongRepository dongRepository;

    @Transactional
    public Dong save(Dong dong){
        return dongRepository.save(dong);
    }

    public Dong findByCode(String code){
        return dongRepository.findByCode(code).orElseThrow(DongNotFoundException::new);
    }
}
