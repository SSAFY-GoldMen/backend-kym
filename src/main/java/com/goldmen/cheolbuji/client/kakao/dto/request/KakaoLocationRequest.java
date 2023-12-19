package com.goldmen.cheolbuji.client.kakao.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class KakaoLocationRequest {
    private String guName;
    private String dongName;
    private String bonNum;
    private String buNum;

    public String makeRoadAddress() {
        return guName + " " + dongName + " " +
                bonNum + "-" + buNum;
    }
}
