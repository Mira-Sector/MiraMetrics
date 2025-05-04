package com.tomd.mira_metrics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetricsResponseStatus {
    private String name;
    private Integer players;
    private String map;


    public String getName() {
        return name;
    }

    public Integer getPlayers() {
        return players;
    }

    public String getMap() {
        return map;
    }
}


