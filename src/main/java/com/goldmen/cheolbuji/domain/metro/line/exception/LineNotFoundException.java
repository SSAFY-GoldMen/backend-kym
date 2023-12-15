package com.goldmen.cheolbuji.domain.metro.line.exception;

import com.goldmen.cheolbuji.global.error.exception.BusinessException;

import static com.goldmen.cheolbuji.global.error.ErrorCode.API_ERROR_LINE_NOT_FOUND;

public class LineNotFoundException extends BusinessException {
    public LineNotFoundException() {
        super(API_ERROR_LINE_NOT_FOUND);
    }
}
