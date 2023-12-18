package com.goldmen.cheolbuji.client.seoulOpenData.rent.service;

import com.goldmen.cheolbuji.client.seoulOpenData.global.vo.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class SeoulOpenDataRentServiceTest {

    @Autowired
    private SeoulOpenDataRentService rentService;

    @DisplayName("매물 데이터 불러오기 테스트")
    @Test
    void loadFileTest() {
        assertDoesNotThrow(()->{
            SeoulOpenDataResponse<SeoulOpenDataRent> response = rentService.loadFile();
            assertEquals(10,response.seoulOpenDataList().size());
        });
    }

    @DisplayName("매물 필터링 테스트")
    @Test
    void filterTest() throws IOException {
        SeoulOpenDataResponse<SeoulOpenDataRent> response = rentService.loadFile();
        List<SeoulOpenDataRent> filteredRentList = rentService.filter(response.seoulOpenDataList());
        assertEquals(3,filteredRentList.size());
    }
}