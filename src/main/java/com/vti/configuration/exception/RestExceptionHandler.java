package com.vti.configuration.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    private String getMessage(String key) {
        return messageSource.getMessage(key, null, "Lỗi server", LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        String message = getMessage("Exception.message");
        String detailMessage = exception.getLocalizedMessage();
        int code = 1;
        String moreInformation = String.format("http://localhost:8080/api/v1/exception/%d", code);

        ErrorResponse response = new ErrorResponse(message, detailMessage, null, code, moreInformation);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
