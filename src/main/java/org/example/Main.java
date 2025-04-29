package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static ObjectMapper mapper = new ObjectMapper();
    public static String API_KEY = "OeIg8Wo1y8oLlLtkdocl1q81ux1c9uEHvwc0rVoa";
    public static void main(String[] args) throws IOException {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build()){
            HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=" + API_KEY);
            CloseableHttpResponse response = httpClient.execute(request);
            Answer answer = mapper.readValue(response.getEntity().getContent(), Answer.class);
            HttpGet request2 = new HttpGet(answer.url);
            final String fileName = answer.url.split("/")[answer.url.split("/").length-1];
            CloseableHttpResponse response2 = httpClient.execute(request2);
            byte[] bytes = response2.getEntity().getContent().readAllBytes();
            try(FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))){
                fileOutputStream.write(bytes);
            }
        }
    }
}