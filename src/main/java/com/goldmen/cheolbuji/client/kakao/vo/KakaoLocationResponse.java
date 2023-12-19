package com.goldmen.cheolbuji.client.kakao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record KakaoLocationResponse(List<KakaoLocation> locationList) {
    public KakaoLocationResponse (@JsonProperty("documents") List<KakaoLocation> locationList){
        this.locationList = locationList;
    }
}
