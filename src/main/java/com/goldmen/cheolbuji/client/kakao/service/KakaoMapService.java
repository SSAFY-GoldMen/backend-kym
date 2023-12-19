package com.goldmen.cheolbuji.client.kakao.service;

import com.goldmen.cheolbuji.client.kakao.dto.request.KakaoLocationRequest;
import com.goldmen.cheolbuji.client.kakao.property.KakaoAddressProperties;
import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocationResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

import static com.goldmen.cheolbuji.client.kakao.property.KakaoAddressProperties.*;

@RequiredArgsConstructor
@Service
public class  KakaoMapService {

    private final WebClient kakaoWebClient;

    public Optional<KakaoLocation> findLocation(KakaoLocationRequest request) {
        KakaoLocationResponse response = fetchAPI(PATH_KAKAO_ADDRESS,request.makeRoadAddress());
        return wrappingOptional(response);
    }

    public Optional<KakaoLocation> findLocation(String keyword) {
        KakaoLocationResponse response = fetchAPI(PATH_KAKAO_KEYWORD,keyword);
        return wrappingOptional(response);
    }

    private Optional<KakaoLocation> wrappingOptional(KakaoLocationResponse response){
        if(response.locationList().isEmpty()) return Optional.empty();
        return Optional.of(response.locationList().get(0));
    }

    private KakaoLocationResponse fetchAPI(String path,String query) {
        return kakaoWebClient
                .method(METHOD_GET)
                .uri(builder -> builder
                        .path(path)
                        .queryParam("query", query)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(KakaoLocationResponse.class)
                .block();
    }
}
