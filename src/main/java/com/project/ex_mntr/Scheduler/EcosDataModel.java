package com.project.ex_mntr.Scheduler;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EcosDataModel {
	
	@JsonProperty("id")
    private Long id;

    @JsonProperty("stat_code")
    private String statCode;

    @JsonProperty("stat_name")
    private String statName;

    @JsonProperty("item_code1")
    private String itemCode1;

    @JsonProperty("item_name1")
    private String itemName1;

    @JsonProperty("item_code2")
    private String itemCode2;

    @JsonProperty("item_name2")
    private String itemName2;

    @JsonProperty("item_code3")
    private String itemCode3;

    @JsonProperty("item_name3")
    private String itemName3;

    @JsonProperty("item_code4")
    private String itemCode4;

    @JsonProperty("item_name4")
    private String itemName4;

    @JsonProperty("unit_name")
    private String unitName;

    @JsonProperty("wgt")
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
