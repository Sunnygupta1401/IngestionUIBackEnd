package org.ingestion.demo.service;

public class SparkJobSubmitter extends Thread {

	final String jsonPath;
	final ConfigService configService;
	public SparkJobSubmitter(String jsonPath,ConfigService configService) {
		this.jsonPath=jsonPath;
		this.configService=configService;
		
	}
	
	@Override
	public void run() {
		try {
			configService.triggerJob(jsonPath);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

