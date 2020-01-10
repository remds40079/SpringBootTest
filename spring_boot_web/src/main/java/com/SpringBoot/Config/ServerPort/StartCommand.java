package com.SpringBoot.Config.ServerPort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.SpringBoot.Utils.ServerPortutils;

public class StartCommand {
	private Logger logger = LoggerFactory.getLogger(StartCommand.class);

	public StartCommand(String[] args) {
		Boolean isServerPort = false;
		String serverPort = "";
		if (args != null) {
			for (String arg : args) {
				if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
					isServerPort = true;
					serverPort = arg;
					break;
				}
			}
		}

//		without port args
		if (!isServerPort) {
			int port = ServerPortutils.getAvailablePort();
			logger.info("current server.port = " + port);
			System.setProperty("server.port", String.valueOf(port));
		} else {
			logger.info("current server.port = " + serverPort.split("=")[1]);
			System.setProperty("server.port", serverPort.split("=")[1]);
		}
	}
}
