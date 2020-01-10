package org.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServerTest {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EurekaServerTest.class);
		application.run(args);
	}
}
