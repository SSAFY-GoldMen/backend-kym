package com.goldmen.cheolbuji.batch.station.service;

import com.goldmen.cheolbuji.batch.map.service.BatchMapService;
import com.goldmen.cheolbuji.batch.station.service.BatchStationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class BatchStationServiceTest {
    @Autowired
    private BatchStationService batchStationService;

    @Autowired
    private BatchMapService batchMapService;

    @Transactional
    @Test
    void initiateTest(){
        assertDoesNotThrow(()->{
            batchMapService.initiate();
            batchStationService.initiate();
        });
    }
}