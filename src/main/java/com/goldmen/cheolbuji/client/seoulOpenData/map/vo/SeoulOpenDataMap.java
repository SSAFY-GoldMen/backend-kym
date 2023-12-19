package com.goldmen.cheolbuji.client.seoulOpenData.map.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SeoulOpenDataMap( String guCode, String guName, String dongCode, String dongName) {
    @JsonCreator
    public SeoulOpenDataMap(
            @JsonProperty("sigungu_cd") String guCode,
            @JsonProperty("sigungu_nm") String guName,
            @JsonProperty("bjdong_cd") String dongCode,
            @JsonProperty("bjdong_nm") String dongName
    ) {
        this.guCode = guCode;
        this.guName = guName;
        this.dongCode = dongCode;
        this.dongName = dongName;
    }
}

