package com.goldmen.cheolbuji.client.seoulOpenData.map.service;

import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.map.vo.SeoulOpenDataMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class SeoulOpenDataMapServiceTest {

    @Autowired
    private SeoulOpenDataMapService mapService;

    @Test
    void loadFileTest() {
        assertDoesNotThrow(()->{
            SeoulOpenDataResponse<SeoulOpenDataMap> response = mapService.loadFile();
            assertEquals(10,response.seoulOpenDataList().size());
        });
    }
}