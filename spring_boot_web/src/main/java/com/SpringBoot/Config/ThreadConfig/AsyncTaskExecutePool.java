package com.SpringBoot.Config.ThreadConfig;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.omg.CORBA.ARG_IN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsyncTaskExecutePool implements AsyncConfigurer{
	private Logger logger = LoggerFactory.getLogger(AsyncTaskExecutePool.class);
	
	@Autowired
	private TaskThreadPoolConfig config;
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(config.getCorePoolSize());
		executor.setMaxPoolSize(config.getMaxPoolSize());
//		executor.setQueueCapacity(config.getQueueCapacity());
		executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        executor.setThreadNamePrefix(config.getThreadNamePrefix());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//		contorl the expection in Async tasks
		return new AsyncUncaughtExceptionHandler() {
			
			@Override
			public void handleUncaughtException(Throwable ex, Method method, Object... params) {
				logger.error("============================"+ ex.getMessage()+ "======================", ex);
				logger.error("exception method:" + method.getName());
			}
		};
	}
	
}
