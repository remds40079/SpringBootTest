package com.SpringBoot.Config.healthIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "ab")
public class UserEndpoint{
	
	@ReadOperation
	public List<Map<String, Object>> health() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("useId", 1001);
		map.put("userName", "remds");
		list.add(map);
		return list;
	}

}
