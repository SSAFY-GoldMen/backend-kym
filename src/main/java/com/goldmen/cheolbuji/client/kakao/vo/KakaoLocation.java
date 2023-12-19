package com.goldmen.cheolbuji.client.kakao.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.cheolbuji.domain.global.Coordinate;

public record KakaoLocation(double lng, double lat, String address) {
    @JsonCreator
    public KakaoLocation(@JsonProperty("x") double lng,
                         @JsonProperty("y") double lat,
                         @JsonProperty("address_name") String address){
        this.lng = lng;
        this.lat = lat;
        this.address = address;
    }

    public Coordinate coordinate(){
        return new Coordinate(lat,lng);
    }

    public String si(){
        return address.split(" ")[0];
    }

    public String gu(){
        return address.split(" ")[1];
    }

    public String dong(){
        return address.split(" ")[2];
    }
}
