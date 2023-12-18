package com.goldmen.cheolbuji.client.seoulOpenData.global.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SeoulOpenDataResponse<T>(List<T> seoulOpenDataList) {
    @JsonCreator
    public SeoulOpenDataResponse(@JsonProperty("DATA") List<T> seoulOpenDataList) {
        this.seoulOpenDataList = seoulOpenDataList;
    }
}
