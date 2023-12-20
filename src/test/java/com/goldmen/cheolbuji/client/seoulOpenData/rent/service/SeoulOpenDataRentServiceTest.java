package com.goldmen.cheolbuji.client.seoulOpenData.rent.service;

import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

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
            assertEquals(1000,response.seoulOpenDataList().subList(0,1000).size());
        });
    }

    @DisplayName("매물 필터링 테스트")
    @Test
    void filterTest() throws IOException {
        SeoulOpenDataResponse<SeoulOpenDataRent> response = rentService.loadFile();
        List<SeoulOpenDataRent> filteredRentList = rentService.filter(response.seoulOpenDataList());
        assertEquals(1000,filteredRentList.subList(0,1000).size());
    }
}