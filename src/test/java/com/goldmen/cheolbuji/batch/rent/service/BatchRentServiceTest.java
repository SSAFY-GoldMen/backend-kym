package com.goldmen.cheolbuji.batch.rent.service;

import com.goldmen.cheolbuji.batch.map.service.BatchMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BatchRentServiceTest {

    @Autowired
    private BatchRentService rentService;
    @Autowired
    private BatchMapService mapService;

    @BeforeEach
    void setUp() throws IOException {
        mapService.initiate();
    }

    @Transactional
    @Test
    void initiateTest() {
        assertDoesNotThrow(()->{
            rentService.initiate();
        });
    }
}