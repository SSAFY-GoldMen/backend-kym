package com.goldmen.cheolbuji.batch.map.service;

import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.map.service.SeoulOpenDataMapService;
import com.goldmen.cheolbuji.client.seoulOpenData.map.vo.SeoulOpenDataMap;
import com.goldmen.cheolbuji.domain.map.dong.service.DongService;
import com.goldmen.cheolbuji.domain.map.gu.domain.Gu;
import com.goldmen.cheolbuji.domain.map.gu.service.GuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class BatchMapService {
    private final SeoulOpenDataMapService seoulOpenDataMapService;
    private final GuService guService;
    private final DongService dongService;

    public void initiate() throws IOException {
        SeoulOpenDataResponse<SeoulOpenDataMap> response = seoulOpenDataMapService.loadFile();
        response.seoulOpenDataList().forEach(map ->{
            Gu gu = guService.save(map.guCode(),map.guName());
            dongService.save(map.dongCode(),map.dongName(),gu);
        });
    }
}
