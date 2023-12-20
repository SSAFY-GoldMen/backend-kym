package com.goldmen.cheolbuji.client.kakao.dto.request;

import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
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

    public static KakaoLocationRequest from(SeoulOpenDataRent rent){
        return KakaoLocationRequest.builder().guName(rent.guName()).dongName(rent.dongName()).bonNum(rent.bonNum()).buNum(rent.buNum()).build();
    }

    public String makeRoadAddress() {
        return guName + " " + dongName + " " +
                bonNum + "-" + buNum;
    }
}
