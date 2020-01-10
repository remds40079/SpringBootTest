package com.SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Config.SBootConfig;

@RestController
public class ConfigController {

	@Autowired
	private SBootConfig sBootConfig;

	@GetMapping("getSBootConfig")
	public String getSBootConfig() {
		return sBootConfig.getName();
	}

}
