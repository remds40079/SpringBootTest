package org.eureka_server.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/remds")
	 public String name() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String result = format.format(date);
//		String result = String.valueOf(date.getTime());
		 return result;
	}
}
