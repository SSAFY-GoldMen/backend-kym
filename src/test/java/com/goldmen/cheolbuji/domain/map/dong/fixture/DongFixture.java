package com.goldmen.cheolbuji.domain.map.dong.fixture;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.fixture.GuFixture;

public enum DongFixture {
    YUKSAMDONG("역삼동","1234"),
    GANGNAMDONG("강남동","4321");

    private final String name;
    private final String code;

    DongFixture(String name, String code) {
        this.name = name;
        this.code = code;
    }



    public Dong create(Gu gu){
        return Dong.builder()
                .name(name)
                .code(code)
                .gu(gu).build();
    }

    public Dong create(){
        return Dong.builder()
                .name(name)
                .code(code)
                .gu(GuFixture.GANGNAMGU.create()).build();
    }
}