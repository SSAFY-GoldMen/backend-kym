package com.goldmen.cheolbuji.domain.map.dong.exception;

import com.goldmen.cheolbuji.global.error.exception.BusinessException;

import static com.goldmen.cheolbuji.global.error.ErrorCode.API_ERROR_DONG_NOT_FOUND;

public class DongNotFoundException extends BusinessException {
    public DongNotFoundException() {
        super(API_ERROR_DONG_NOT_FOUND);
    }
}
