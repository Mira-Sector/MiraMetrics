package com.tomd.mira_metrics.service;

import com.tomd.mira_metrics.model.MetricsResponseStatus;
import org.springframework.stereotype.Service;


public interface MetricService {
    public MetricsResponseStatus getResponse();
    public Integer getPlayerCount();
    public String getCurrentMap();
    public MetricsResponseStatus parseJson(String jsonString);
}
