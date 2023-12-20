package com.goldmen.cheolbuji.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    API_ERROR_INTERNAL_SERVER(500, "G001", "서버 오류"),
    API_ERROR_INPUT_INVALID_VALUE(409, "G002", "잘못된 입력"),

    // Dong
    API_ERROR_DONG_NOT_FOUND(400,"D001","존재하지 않음"),

    // Gu
    API_ERROR_GU_NOT_FOUND(400,"G001","존재하지 않음"),

    // Line
    API_ERROR_LINE_NOT_FOUND(400,"L001","존재하지 않음"),

    //Station
    API_ERROR_STATION_NOT_FOUND(400,"S001","존재하지 않음"),

    //Adjacent
    API_ERROR_ADJACENT_NOT_FOUND(400,"A001","존재하지 않음"),

    //Rent
    API_ERROR_RENT_NOT_FOUND(400,"R001","존재하지 않음"),

    //Jeonse
    API_ERROR_JEONSE_NOT_FOUND(400,"J001","존재하지 않음"),

    //Walse
    API_ERROR_WALSE_NOT_FOUND(400,"W001","존재하지 않음"),
    ;
    private final int status;
    private final String code;
    private final String message;
}