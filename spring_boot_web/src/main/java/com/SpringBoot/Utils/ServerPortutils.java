package com.SpringBoot.Utils;

import java.util.Random;

public class ServerPortutils {

	public static int getAvailablePort() {
		int max = 655355;
		int min = 2000;
		Random random = new Random();
		int port = random.nextInt(max) % (max - min + 1) + min;
		boolean using = NetUtils.isLocalPortUsing(port);
		if (using) {
			return getAvailablePort();
		} else {
			return port;
		}

	}
}
