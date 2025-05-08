package com.tomd.mira_metrics.index.ui;

import com.tomd.mira_metrics.service.MetricService;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Home")
public class SampleView extends VerticalLayout {
    MetricService metricService;

    public SampleView(MetricService metricService) {
        this.metricService = metricService;
        add(new H2(metricService.getPlayerCount().toString()));
        setSizeFull();
    }
}
