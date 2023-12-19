package com.goldmen.cheolbuji.client.seoulOpenData.station.service;

import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.station.vo.SeoulOpenDataStation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class SeoulOpenDataStationServiceTest {
    @Autowired
    private SeoulOpenDataStationService stationService;
    
    @Test
    void loadFileTest() {
        assertDoesNotThrow(()->{
            SeoulOpenDataResponse<SeoulOpenDataStation> response = stationService.loadFile();
            assertEquals(777,response.seoulOpenDataList().size());
        });
    }
}