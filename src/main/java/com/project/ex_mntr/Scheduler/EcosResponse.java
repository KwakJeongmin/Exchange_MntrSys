package com.project.ex_mntr.Scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EcosResponse {
    @JsonProperty("StatisticSearch")
    private StatisticSearch statisticSearch;
}
