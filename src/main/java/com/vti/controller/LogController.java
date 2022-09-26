package com.vti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "api/v1/logs")
@Log4j2
public class LogController {
	@GetMapping
	public void testLog() {
		log.info("info ...");
		log.debug("debug ...");
		log.warn("warning ...");
		log.error("error...");
		log.trace("trace...");
	}
}
