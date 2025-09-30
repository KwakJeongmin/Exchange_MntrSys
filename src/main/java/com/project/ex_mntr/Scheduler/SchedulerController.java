package com.project.ex_mntr.Scheduler;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SchedulerController {

	private final SchedulerService schedulerService;
	
	public SchedulerController(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}	
	
//	@Scheduled(cron = "0 0 8 7 * *") // 매월 7일 마다 8시 실행
//	@Scheduled(cron = "0 0/1 * * * *")
	public void schedule1Day() {
		try {
			scheduleEcosData(null);
		}catch(BadSqlGrammarException ex) {
			System.err.println("_Sql_Errors");
		}catch(Exception e) {
			System.err.println("_Errors");
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/scheduleEcosData.pms")
	public void scheduleEcosData(@RequestParam(value = "datetime", required = false) String datetime) {
		try {
			schedulerService.scheduleEcosData(datetime);
		}catch(BadSqlGrammarException ex) {
			System.err.println("_Sql_Errors");
		}catch(Exception e) {
			System.err.println("_Errors");
			e.printStackTrace();
		}
	}
	
}
