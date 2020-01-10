package com.SpringBoot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringBoot.Config.MyConfig;
import com.SpringBoot.Config.ServerPort.StartCommand;
import com.SpringBoot.Config.healthIndicator.UserEndpoint;

@EnableCaching
@SpringBootApplication
@EnableConfigurationProperties({MyConfig.class})
public class SpringApp {
	
	 public static void main(String[] args) {
//		SpringApplication.run(SpringApp.class, args);
		 new StartCommand(args);
		 SpringApplication application = new SpringApplication(SpringApp.class);
//		close the banner
		 application.setBannerMode(Mode.OFF);
		 application.run(args);
	}
	 
	 @Configuration
	 static class UserEndpointConfiguration{
		 @Bean
		 @ConditionalOnMissingBean
		 @ConditionalOnEnabledEndpoint
		 public UserEndpoint userEndpoint() {
			 return new UserEndpoint();
		 }
		 
	 }
}
