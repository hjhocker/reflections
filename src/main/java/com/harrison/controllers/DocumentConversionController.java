package com.harrison.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/api/documentConversion")
public class DocumentConversionController {

    @RequestMapping
    public ResponseEntity<byte[]> convert() throws IOException {

        Path path = Paths.get("/Users/harrisonhocker/Documents/testing.docx");
        byte[] data = Files.readAllBytes(path);
        RestTemplate rt = new RestTemplate();

        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        ByteArrayResource bar = new ByteArrayResource(data) {
            @Override
            public String getFilename() {
                return "testing.docx";
            }
        };
        map.add("file", bar);
        map.add("inputformat", "docx");
        map.add("outputformat", "pdf");
        map.add("input", "upload");
        map.add("wait", true);
        map.add("download", true);

        HttpHeaders headers = new HttpHeaders();
        String apikey = "ZST2_kk2o72t-xsf6GA8i99g3vSdaoSZElVcfJ_d-BRUpn5gyjA7MYJiWOWvSaZ8_nLd7g2vaCRa6uuTbM49nw";
        headers.add("Authorization", "Bearer " + apikey);

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);

        return rt.exchange("https://api.cloudconvert.com/convert", HttpMethod.POST, entity, byte[].class);
    }

}
