package com.ps.sync.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	 @Override
	    @Bean
	    public Executor getAsyncExecutor()
	    {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(50);
	        executor.setMaxPoolSize(500);
	        executor.setQueueCapacity(500);
	        executor.setThreadNamePrefix("GeneralExecutor-");
	        executor.initialize();
	        return executor;
	    }
	    
	    @Override
	    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
	    {
	        return new AsyncUncaughtExceptionHandler()
	        {
	            public void handleUncaughtException(Throwable ex, Method method, Object... params)
	            {
	                System.out.println(String.format("asynchronously processing error:method={method}, parameters={params}",
	                    method.toString(),
	                    params.toString()));
	            }
	        };
	    }
}
