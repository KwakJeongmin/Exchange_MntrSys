package com.project.ex_mntr.Scheduler;

import org.apache.ibatis.annotations.Mapper;

import com.project.ex_mntr.annotation.UseDefaultDatasource;

@Mapper
@UseDefaultDatasource
public interface SchedulerMapper {
	
	public void scheduleEcosData(EcosDataModel ecosDataModel);

}
