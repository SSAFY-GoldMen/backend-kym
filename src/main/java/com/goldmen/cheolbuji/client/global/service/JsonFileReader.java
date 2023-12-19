package com.goldmen.cheolbuji.client.global.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JsonFileReader implements FileReader{

    private final ObjectMapper objectMapper;

    @Override
    public  <T> T readFile(String path, TypeReference<T> typeValue) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        return objectMapper.readValue(resource.getInputStream(), typeValue);
    }
}
