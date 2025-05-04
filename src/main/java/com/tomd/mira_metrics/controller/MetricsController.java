package com.tomd.mira_metrics.controller;

import com.tomd.mira_metrics.service.MetricService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MetricsController {

    MetricService metricService;

    public MetricsController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/getPlayerCount")
    public String getPlayerCount(){
        return metricService.getPlayerCount().toString();
    }
}
