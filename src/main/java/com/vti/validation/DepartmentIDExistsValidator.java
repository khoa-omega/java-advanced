package com.vti.validation;

import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentIDExistsValidator implements ConstraintValidator<DepartmentIDExists, Integer> {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}
