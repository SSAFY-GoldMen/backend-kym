package com.goldmen.cheolbuji.client.global.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public interface FileReader {
    <T> T readFile(String path, TypeReference<T> typeValue) throws IOException;
}
