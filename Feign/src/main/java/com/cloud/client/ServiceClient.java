package com.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service")
public interface ServiceClient {
	
	@GetMapping("/test/{text}")
	public ResponseEntity<String> feign(@PathVariable("text") String text);
	
	@GetMapping("/zone")
	public String zone();

}
