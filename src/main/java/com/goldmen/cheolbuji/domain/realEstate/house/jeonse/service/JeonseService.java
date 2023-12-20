package com.goldmen.cheolbuji.domain.realEstate.house.jeonse.service;

import com.goldmen.cheolbuji.domain.realEstate.house.jeonse.domain.Jeonse;
import com.goldmen.cheolbuji.domain.realEstate.house.jeonse.domain.JeonseRepository;
import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JeonseService {
    private final JeonseRepository jeonseRepository;

    public Jeonse save(Rent rent, int price){
        return jeonseRepository.save(Jeonse.builder().rent(rent).price(price).build());
    }
}
