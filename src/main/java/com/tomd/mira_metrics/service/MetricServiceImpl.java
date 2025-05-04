package com.tomd.mira_metrics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomd.mira_metrics.model.MetricsResponseStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class MetricServiceImpl implements MetricService {
    @Override
    public MetricsResponseStatus getResponse() {
        String url = "https://ss14.mira-sector.xyz/status";
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }


        return parseJson(response.body());
    }

    @Override
    public Integer getPlayerCount() {
        return getResponse().getPlayers();
    }

    @Override
    public String getCurrentMap() {
        return getResponse().getMap();
    }

    @Override
    public MetricsResponseStatus parseJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        MetricsResponseStatus metric;
        try {
            metric = mapper.readValue(jsonString, MetricsResponseStatus.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return metric;
    }
}
