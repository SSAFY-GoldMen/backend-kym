package com.goldmen.cheolbuji.client.seoulOpenData.map.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.goldmen.cheolbuji.client.global.service.FileReader;
import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.map.vo.SeoulOpenDataMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataProperties.PATH_INFORM_MAP;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataMapService {
    private final FileReader jsonFileService;

    public SeoulOpenDataResponse<SeoulOpenDataMap> loadFile() throws IOException {
        return jsonFileService.readFile(PATH_INFORM_MAP, new TypeReference<>() {});
    }
}
