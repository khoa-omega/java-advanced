package com.vti.controller;

import com.vti.dto.ProfileDTO;
import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IAccountService service;

    @GetMapping("/login")
    public ProfileDTO login(Principal principal) {
        String username = principal.getName();
        Account entity = service.findByUsername(username);
        return mapper.map(entity, ProfileDTO.class);
    }
}
