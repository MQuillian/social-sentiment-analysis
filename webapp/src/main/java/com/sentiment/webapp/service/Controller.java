package com.sentiment.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final DataService service;

	@Autowired
	public Controller(DataService myService) {
		this.service = myService;
	}

	@GetMapping("/")
	public String home() {
		return service.message();
	}
}