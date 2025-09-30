package com.project.ex_mntr.Scheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class SchedulerService {

	Logger logger = LoggerFactory.getLogger( getClass() );
	private final SchedulerMapper schedulerMapper;
	
	@Value("${ecos.api.key}")
    private String apiKey;
	
	public SchedulerService(SchedulerMapper schedulerMapper) {
		this.schedulerMapper = schedulerMapper;
	}
	
	public void scheduleEcosData(String datetime) throws Exception {
		// 1. 오늘 날짜
        LocalDate today = LocalDate.now();
        // 2. 어제 날짜
        LocalDate yesterday = today.minusDays(1);
        
        // 3. API에서 요구하는 형식: YYYYMMDD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String startDate = yesterday.format(formatter);
        String endDate = today.format(formatter);
        
        System.out.println(startDate);
        System.out.println(endDate);
		
		String apiUrl = "https://ecos.bok.or.kr/api/StatisticSearch/"+apiKey+"/json/kr/1/1000/731Y001/D/"+startDate+"/"+endDate+"/0000001";
		
		ObjectMapper objectMapper = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			String apiResponse = getApiData(apiUrl);
			System.out.println("=== API Response ===");
			System.out.println(apiResponse);
			
			System.out.println("\n=== Attempting to map response ===");
			EcosResponse response = objectMapper.readValue(apiResponse, EcosResponse.class);
			System.out.println("EcosResponse mapped: " + response);
			
			if (response != null) {
				System.out.println("StatisticSearch: " + response.getStatisticSearch());
				
				if (response.getStatisticSearch() != null) {
					System.out.println("Rows: " + response.getStatisticSearch().getRows());
					
					if (response.getStatisticSearch().getRows() != null && 
						!response.getStatisticSearch().getRows().isEmpty()) {
						
						EcosDataModel ecosDataModel = response.getStatisticSearch().getRows().get(0);
						System.out.println("\n=== Mapped Model ===");
						System.out.println(ecosDataModel);
						
						schedulerMapper.scheduleEcosData(ecosDataModel);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("\n=== Error Details ===");
			System.out.println("Error type: " + e.getClass().getName());
			System.out.println("Error message: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String getApiData(String apiUrl) {
		RestTemplate restTemplate = new RestTemplate();
        // REST API 호출 및 응답 받기
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
		// API 데이터 BODY값 추출
		String responseBody = responseEntity.getBody();
		
		return responseBody;
	}
}
