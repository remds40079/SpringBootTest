package com.eureka;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;

@Component
public class EurekaStateChangeListener {

	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + "server is down");
	}

	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		InstanceInfo info = event.getInstanceInfo();
		System.err.println(info.getAppName() + "is register");
	}

	@EventListener
	public void listen(EurekaInstanceRenewedEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + "server renew");
	}

	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		System.err.println("register center is booting");
	}

	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		System.err.println("eureka Server booting");

	}

}
