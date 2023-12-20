package com.goldmen.cheolbuji.domain.realEstate.house.walse.service;

import com.goldmen.cheolbuji.domain.realEstate.house.rent.domain.Rent;
import com.goldmen.cheolbuji.domain.realEstate.house.walse.domain.Walse;
import com.goldmen.cheolbuji.domain.realEstate.house.walse.domain.WalseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalseService {
    private final WalseRepository walseRepository;

    public Walse save(Rent rent, int price, int monthlyPrice) {
        return walseRepository.save(Walse.builder().rent(rent).price(price).monthlyPrice(monthlyPrice).build());
    }
}
