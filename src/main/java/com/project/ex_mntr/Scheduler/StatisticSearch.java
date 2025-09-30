package com.project.ex_mntr.Scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class StatisticSearch {
    @JsonProperty("list_total_count")
    private Integer listTotalCount;
    
    @JsonProperty("row")
    private List<EcosDataModel> rows;
}
