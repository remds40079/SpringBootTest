package org.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/article/test")
	public String callremds() {
		return restTemplate.getForObject("http://localhost:8081/remds", String.class);
	}
	
	@GetMapping("/article/test2")
	public String callremds2() {
		return restTemplate.getForObject("http://eureka-client-user-service/remds", String.class);
	}
	
}
