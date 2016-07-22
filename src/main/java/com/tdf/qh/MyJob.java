package com.tdf.qh;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/*
 * quartz定时器测试
 * 
 */

public class MyJob implements Job {
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(new Date() + ": doing something...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 创建JobDetail对象
		JobDetail jobDetail = new JobDetail();
		
		// 设置工作项
		jobDetail.setJobClass(MyJob.class);
		jobDetail.setName("MyJob_1");
		jobDetail.setGroup("JobGroup_1");
		
		// 创建Trigger对象
		SimpleTrigger strigger = new SimpleTrigger();
		strigger.setName("Trigger_1");
		strigger.setGroup("Trigger_Group_1");
		strigger.setStartTime(new Date());
		// 设置重复停止时间，并销毁该Trigger对象
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L);
		strigger.setEndTime(calendar.getTime());
		strigger.setFireInstanceId("Trigger_1_id_001");
		// 设置重复时间间隔
		strigger.setRepeatInterval(800 * 1L);
		// 设置重复执行次数
		strigger.setRepeatCount(3);
		
		// 创建scheduler对象, 并配置JobDetail和Trigger对象
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
			scheduler.scheduleJob(jobDetail, strigger);
			// 执行启动、关闭等操作
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(100);
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
