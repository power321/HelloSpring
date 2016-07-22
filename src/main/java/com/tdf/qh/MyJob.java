package com.tdf.qh;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/*
 * quartz��ʱ������
 * 
 */

public class MyJob implements Job {
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(new Date() + ": doing something...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// ����JobDetail����
		JobDetail jobDetail = new JobDetail();
		
		// ���ù�����
		jobDetail.setJobClass(MyJob.class);
		jobDetail.setName("MyJob_1");
		jobDetail.setGroup("JobGroup_1");
		
		// ����Trigger����
		SimpleTrigger strigger = new SimpleTrigger();
		strigger.setName("Trigger_1");
		strigger.setGroup("Trigger_Group_1");
		strigger.setStartTime(new Date());
		// �����ظ�ֹͣʱ�䣬�����ٸ�Trigger����
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis() + 1000 * 1L);
		strigger.setEndTime(calendar.getTime());
		strigger.setFireInstanceId("Trigger_1_id_001");
		// �����ظ�ʱ����
		strigger.setRepeatInterval(800 * 1L);
		// �����ظ�ִ�д���
		strigger.setRepeatCount(3);
		
		// ����scheduler����, ������JobDetail��Trigger����
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
			scheduler.scheduleJob(jobDetail, strigger);
			// ִ���������رյȲ���
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
