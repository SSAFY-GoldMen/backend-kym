package com.goldmen.cheolbuji.domain.realEstate.house.rent.exception;

import com.goldmen.cheolbuji.global.error.ErrorCode;
import com.goldmen.cheolbuji.global.error.exception.BusinessException;

public class RentNotFoundException extends BusinessException {
    public RentNotFoundException() {
        super(ErrorCode.API_ERROR_RENT_NOT_FOUND);
    }
}
