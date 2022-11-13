package com.vti.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/logs")
public class LogController {
    @GetMapping
    public String logs() {
        log.info("INFO: ...");
        log.debug("DEBUG: ...");
        log.warn("WARN: ...");
        log.error("ERROR: ...");
        log.trace("TRACE: ...");
        return "Please checkout the logs to see the output...";
    }
}
