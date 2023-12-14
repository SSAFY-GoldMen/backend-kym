package com.goldmen.cheolbuji.domain.metro.line.fixture;

import com.goldmen.cheolbuji.domain.metro.line.domain.Line;

public enum LineFixture {
    LINE_1("1호선"),
    LINE_2("2호선");
    private final String name;

    LineFixture(String name){
        this.name = name;
    }
    public Line create(){
        return Line.builder().name(name).build();
    }
}
