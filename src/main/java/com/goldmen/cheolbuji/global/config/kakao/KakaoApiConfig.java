package com.goldmen.cheolbuji.global.config.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Configuration
public class KakaoApiConfig {

    private final KakaoProperties kakaoProperties;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
                .baseUrl(kakaoProperties.getBaseUrl())
                .defaultHeader("Authorization", kakaoProperties.getDefaultHeader())
                .build();
    }
}
