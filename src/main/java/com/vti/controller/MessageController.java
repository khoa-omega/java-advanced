package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    @Autowired
    private MessageSource messageSource;

    private final Locale VIETNAMESE = new Locale("vi");

    @GetMapping
    public String getMessage(@RequestParam String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/vi")
    public String getMessageVi(@RequestParam String code) {
        return messageSource.getMessage(code, null, VIETNAMESE);
    }

    @GetMapping("/en")
    public String getMessageEn(@RequestParam String code) {
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }
}
