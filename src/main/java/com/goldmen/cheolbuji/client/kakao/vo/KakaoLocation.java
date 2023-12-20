package com.goldmen.cheolbuji.client.kakao.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.cheolbuji.domain.global.Coordinate;

public record KakaoLocation(double lng, double lat, String address_name) {
    @JsonCreator
    public KakaoLocation(@JsonProperty("x") double lng,
                         @JsonProperty("y") double lat,
                         @JsonProperty("address_name") String address_name){
        this.lng = lng;
        this.lat = lat;
        this.address_name = address_name;
    }

    public Coordinate coordinate(){
        return new Coordinate(lat,lng);
    }


    public String siName(){
        return address_name.split(" ")[0];
    }

    public String guName(){
        return address_name.split(" ")[1];
    }

    public String dongName(){
        return address_name.split(" ")[2];
    }
}
