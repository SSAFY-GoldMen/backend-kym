package com.goldmen.cheolbuji.batch.map.service;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import com.goldmen.cheolbuji.domain.map.dong.domain.DongRepository;
import com.goldmen.cheolbuji.domain.map.dong.service.DongService;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.domain.GuRepository;
import com.goldmen.cheolbuji.domain.map.gu.service.GuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional(readOnly = true)
@SpringBootTest
class BatchMapServiceTest {

    @Autowired
    private BatchMapService batchMapService;

    @Autowired
    private GuRepository guRepository;

    @Autowired
    private DongRepository dongRepository;

    @Transactional
    @Test
    void initiateTest() {
        assertDoesNotThrow(()->{
            batchMapService.initiate();
        });

        List<Gu> guList = guRepository.findAll();
        List<Dong> dongList = dongRepository.findAll();

        assertEquals(5,guList.size());
        assertEquals(10,dongList.size());
    }
}