package com.goldmen.cheolbuji.client.kakao.service;

import com.goldmen.cheolbuji.client.kakao.dto.request.KakaoLocationRequest;
import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocation;
import com.goldmen.cheolbuji.client.kakao.vo.KakaoLocationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class KakaoMapServiceTest {
    @Autowired
    private KakaoMapService kakaoMapService;

    @DisplayName("Location 찾기")
    @Nested
    class findLocation{
        @DisplayName("주소로 찾기")
        @Nested
        class byRequest{

            @DisplayName("성공 시")
            @Test
            void findLocationByRequestTestWhenExist() {
                KakaoLocationRequest request = KakaoLocationRequest.builder().guName("은평구").dongName("불광동").bonNum("0105").buNum("0076").build();
                Optional<KakaoLocation> location = kakaoMapService.findLocation(request);
                assertTrue(location.isPresent());
            }

            @DisplayName("실패 시")
            @Test
            void findLocationByRequestTestWhenFail() {
                KakaoLocationRequest request = KakaoLocationRequest.builder().guName("서울구").dongName("불광동").bonNum("0105").buNum("0076").build();
                Optional<KakaoLocation> location = kakaoMapService.findLocation(request);
                assertTrue(location.isEmpty());
            }
        }

        @DisplayName("키워드로 찾기")
        @Nested
        class byKeyword{
            @DisplayName("성공 시")
            @Test
            void findLocationByKeywordWhenExist() {
                Optional<KakaoLocation> location = kakaoMapService.findLocation("강남역");
                assertTrue(location.isPresent());
            }

            @DisplayName("실패 시")
            @Test
            void findLocationByKeywordWhenFail() {
                Optional<KakaoLocation> location = kakaoMapService.findLocation("철부지역");
                assertTrue(location.isEmpty());
            }
        }
    }
}