package com.goldmen.cheolbuji.domain.metro.station.exception;

import com.goldmen.cheolbuji.global.error.ErrorCode;
import com.goldmen.cheolbuji.global.error.exception.BusinessException;

public class StationNotFoundException extends BusinessException {
    public StationNotFoundException() {
        super(ErrorCode.API_ERROR_STATION_NOT_FOUND);
    }
}
