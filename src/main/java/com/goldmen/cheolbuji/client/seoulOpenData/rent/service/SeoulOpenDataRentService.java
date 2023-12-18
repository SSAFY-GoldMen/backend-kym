package com.goldmen.cheolbuji.client.seoulOpenData.rent.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.goldmen.cheolbuji.client.global.service.JsonFileReader;
import com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataResponse;
import com.goldmen.cheolbuji.client.seoulOpenData.rent.vo.SeoulOpenDataRent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.goldmen.cheolbuji.client.seoulOpenData.global.SeoulOpenDataProperties.PATH_INFORM_RENT;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataRentService extends JsonFileReader<SeoulOpenDataResponse<SeoulOpenDataRent>> {

    @Override
    protected SeoulOpenDataResponse<SeoulOpenDataRent> loadFile() throws IOException {
        return loadFile(PATH_INFORM_RENT, new TypeReference<>() {});
    }

    public List<SeoulOpenDataRent> filter(List<SeoulOpenDataRent> rentList) {
        return rentList.stream()
                .filter(row -> !row.rentType().equals("매매"))
                .filter(row -> row.cntrctPrd() == null || row.cntrctPrd().isEmpty())
                .filter(row -> row.bonNum() != null && !row.bonNum().isEmpty())
                .filter(row -> row.buNum() != null && !row.buNum().isEmpty())
                .filter(row -> row.dongCode() != null && !row.dongCode().isEmpty())
                .filter(row -> row.dongName() != null && !row.dongName().isEmpty())
                .filter(row -> row.guCode() != null && !row.guCode().isEmpty())
                .filter(row -> row.guName() != null && !row.guName().isEmpty())
                .filter(row -> row.price() != 0)
                .filter(row -> row.constructorYear() != 0)
                .filter(row -> row.area() != 0D)
                .filter(row -> row.floor() != 0D)
                .collect(Collectors.toList());
    }
}
