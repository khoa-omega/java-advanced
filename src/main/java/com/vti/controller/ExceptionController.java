package com.vti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/exceptions")
public class ExceptionController {
    @GetMapping
    public void throwException() {
        throw new EntityNotFoundException("... Exception information");
    }
}
