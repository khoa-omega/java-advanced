package com.vti.validation;

import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountUsernameNotExistsValidator implements ConstraintValidator<AccountUsernameNotExists, String> {
    @Autowired
    private IAccountRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.hasText(username)) {
            return !repository.existsByUsername(username);
        }
        return true;
    }
}
