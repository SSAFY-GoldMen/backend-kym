package com.goldmen.cheolbuji.client.seoulOpenData.rent.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SeoulOpenDataRent(String houseType,String accYear, String guCode, String guName, String dongCode, String dongName,
                                String bonNum, String buNum, int floor, String cntrctDe, String rentType, double area,
                                int price, int rent, int constructorYear, String cntrctPrd) {
    @JsonCreator
    public SeoulOpenDataRent(
            @JsonProperty("house_gbn_nm") String houseType,
            @JsonProperty("acc_year") String accYear,
            @JsonProperty("sgg_cd") String guCode,
            @JsonProperty("sgg_nm") String guName,
            @JsonProperty("bjdong_cd") String dongCode,
            @JsonProperty("bjdong_nm") String dongName,
            @JsonProperty("bobn") String bonNum,
            @JsonProperty("bubn") String buNum,
            @JsonProperty("flr_no") int floor,
            @JsonProperty("cntrct_de") String cntrctDe,
            @JsonProperty("rent_gbn") String rentType,
            @JsonProperty("rent_area") double area,
            @JsonProperty("rent_gtn") int price,
            @JsonProperty("rent_fee") int rent,
            @JsonProperty("build_year") int constructorYear,
            @JsonProperty("cntrct_prd") String cntrctPrd){
        this.houseType = houseType;
        this.accYear = accYear;
        this.guCode = guCode;
        this.guName = guName;
        this.dongCode = dongCode;
        this.dongName = dongName;
        this.bonNum = bonNum;
        this.buNum = buNum;
        this.floor = floor;
        this.cntrctDe = cntrctDe;
        this.rentType = rentType;
        this.area = area;
        this.price = price;
        this.rent = rent;
        this.constructorYear = constructorYear;
        this.cntrctPrd = cntrctPrd;
    }
}
