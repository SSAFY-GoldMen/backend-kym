package com.goldmen.cheolbuji.client.seoulOpenData.station.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SeoulOpenDataStation(String stationName, String stationCode, String lineNum, String frCode) {

    @JsonCreator
    public SeoulOpenDataStation(
            @JsonProperty("station_nm") String stationName,
            @JsonProperty("station_cd") String stationCode,
            @JsonProperty("line_num") String lineNum,
            @JsonProperty("fr_code") String frCode) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.lineNum = lineNum;
        this.frCode = frCode;
    }
}
