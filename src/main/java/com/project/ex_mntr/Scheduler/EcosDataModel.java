package com.project.ex_mntr.Scheduler;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EcosDataModel {
	
	@JsonProperty("id")
    private Long id;

    @JsonProperty("STAT_CODE")
    private String statCode;

    @JsonProperty("STAT_NAME")
    private String statName;

    @JsonProperty("ITEM_CODE1")
    private String itemCode1;

    @JsonProperty("ITEM_NAME1")
    private String itemName1;

    @JsonProperty("ITEM_CODE2")
    private String itemCode2;

    @JsonProperty("ITEM_NAME2")
    private String itemName2;

    @JsonProperty("ITEM_CODE3")
    private String itemCode3;

    @JsonProperty("ITEM_NAME3")
    private String itemName3;

    @JsonProperty("ITEM_CODE4")
    private String itemCode4;

    @JsonProperty("ITEM_NAME4")
    private String itemName4;

    @JsonProperty("UNIT_NAME")
    private String unitName;

    @JsonProperty("WGT")
    private String wgt;

    @JsonProperty("base_date")
    private LocalDate baseDate;

    @JsonProperty("data_value")
    private BigDecimal dataValue;

    @JsonProperty("created_at")
    private String createdAt; // timestamp는 DB 자동 처리, 필요 시 LocalDateTime

    @JsonProperty("updated_at")
    private String updatedAt; // timestamp는 DB 자동 처리, 필요 시 LocalDateTime

}
