package com.goldmen.cheolbuji.domain.map.gu.exception;

import com.goldmen.cheolbuji.global.error.ErrorCode;
import com.goldmen.cheolbuji.global.error.exception.BusinessException;

import static com.goldmen.cheolbuji.global.error.ErrorCode.API_ERROR_GU_NOT_FOUND;

public class GuNotFoundException extends BusinessException {
    public GuNotFoundException() {
        super(API_ERROR_GU_NOT_FOUND);
    }
}
