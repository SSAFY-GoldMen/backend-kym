package com.goldmen.cheolbuji.client.seoulOpenData.station.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.goldmen.cheolbuji.client.global.service.FileReader;
import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.map.vo.SeoulOpenDataMap;
import com.goldmen.cheolbuji.client.seoulOpenData.station.vo.SeoulOpenDataStation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataProperties.PATH_INFORM_STATION;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataStationService {
    private final FileReader jsonFileService;

    public SeoulOpenDataResponse<SeoulOpenDataStation> loadFile() throws IOException {
        return jsonFileService.readFile(PATH_INFORM_STATION, new TypeReference<>() {});
    }
}
