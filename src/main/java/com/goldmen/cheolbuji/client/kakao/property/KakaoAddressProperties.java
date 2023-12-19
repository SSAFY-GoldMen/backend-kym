package com.goldmen.cheolbuji.client.kakao.property;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class KakaoAddressProperties {
    public static final HttpMethod METHOD_GET = HttpMethod.GET;
    public static final String PATH_KAKAO_ADDRESS = "v2/local/search/address.json";
    public static final String PATH_KAKAO_KEYWORD = "v2/local/search/keyword.json";
}
