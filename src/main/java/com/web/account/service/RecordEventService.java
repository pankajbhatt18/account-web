package com.web.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.account.dao.EventLoggingDao;
import com.web.account.model.EventLogging;

@Component
public class RecordEventService implements Runnable   {

	@Autowired
	private EventLoggingDao eventLoggingDao; 
	
	private EventLogging eventLogging;
	
	public void recordEvent(EventLogging logging)
	{
		this.eventLogging=logging;
	}
	
	@Override
	public void run() {
		if(true) {
			eventLoggingDao.save(eventLogging);			
		}
	}
	

	

}
