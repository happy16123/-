package com.cloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.client.ServiceClient;

@RestController
public class FeignController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignController.class);
	
	@Autowired
	private ServiceClient serviceClient;
	
	@GetMapping("/")
	public String getZone(){
		String str = serviceClient.zone();
		return str;
	}
	
	@GetMapping("/test")
	public ResponseEntity<Map<String, String>> getTest(){
		Map<String, String> map = new HashMap<String, String>();
		ResponseEntity<String> data = serviceClient.feign("zxczxc");
		map.put("feign", data.getBody());
		map.put("origin", "testtest");
		
		return ResponseEntity.ok(map);
	}
}
