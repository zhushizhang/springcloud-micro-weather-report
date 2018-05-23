package com.supcon.cloud.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.supcon.cloud.job.WeatherDataSyncJob;

@Configuration
public class QuartzConfiguration {

	private static final int TIME = 1800;
	//jobDetail
	@Bean
	public JobDetail WeatherDataSyncJobJobDetail(){
		return JobBuilder.newJob(WeatherDataSyncJob.class)
				.withIdentity("WeatherDataSyncJob")
				.storeDurably().build();
	}
	//Trigger
	@Bean
	public Trigger WeatherDataSyncTrigger(){
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();
		return TriggerBuilder.newTrigger()
		.forJob(WeatherDataSyncJobJobDetail())
		.withIdentity("WeatherDataSyncTrigger")
		.withSchedule(schedBuilder).build();
	}
}
