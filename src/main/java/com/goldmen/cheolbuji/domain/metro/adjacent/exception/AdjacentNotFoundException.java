package com.goldmen.cheolbuji.domain.metro.adjacent.exception;

import com.goldmen.cheolbuji.global.error.ErrorCode;
import com.goldmen.cheolbuji.global.error.exception.BusinessException;

public class AdjacentNotFoundException extends BusinessException {
    public AdjacentNotFoundException() {
        super(ErrorCode.API_ERROR_ADJACENT_NOT_FOUND);
    }
}
