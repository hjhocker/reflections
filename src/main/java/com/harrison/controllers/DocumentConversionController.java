package com.harrison.controllers;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/api/documentConversion")
public class DocumentConversionController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<byte[]> convert() throws IOException {

        Path path = Paths.get("/Users/harrisonhocker/Documents/testing.docx");
        byte[] data = Files.readAllBytes(path);
        RestTemplate rt = new RestTemplate();

        HttpClient httpClient = HttpClientBuilder.create()
                                    .setRedirectStrategy(new LaxRedirectStrategy())
                                    .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        rt.setRequestFactory(factory);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        ByteArrayResource bar = new ByteArrayResource(data) {
            @Override
            public String getFilename() {
                return "testing.docx";
            }
        };
        String apikey = "ml_6YlEN2JRpg1wBOfg7ezNVB79t941oaa_JWkIAMBEdblQPYOIGsZ13s7NA2_JgDOacYLGiEzLvJdqst1MT5w";
        map.add("file", bar);
        map.add("inputformat", "docx");
        map.add("outputformat", "pdf");
        map.add("input", "upload");
        map.add("wait", true);
        map.add("download", true);
        map.add("apikey", apikey);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<byte[]> response = rt.exchange("https://api.cloudconvert.com/convert", HttpMethod.POST, entity, byte[].class);

        byte[] stuff = response.getBody();

        return new ResponseEntity<>(stuff, HttpStatus.OK);
    }

}
