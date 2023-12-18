package com.goldmen.cheolbuji.client.global.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public abstract class JsonFileReader<T>{
    @Autowired
    private ObjectMapper objectMapper;

    protected T loadFile(String path, TypeReference<T> typeValue) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        return objectMapper.readValue(resource.getInputStream(), typeValue);
    }

    protected abstract T loadFile() throws IOException;
}
