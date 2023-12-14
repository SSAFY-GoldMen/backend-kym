package com.goldmen.cheolbuji.domain.map.gu.fixture;

import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import lombok.AllArgsConstructor;

public enum GuFixture {
    GANGNAMGU("강남구", "1100"),
    YUKSAMGU("역삼구", "0011");

    private final String name;
    private final String code;

    GuFixture(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Gu create() {
        return Gu.builder()
                .name(name)
                .code(code).build();
    }
}