package com.example.demo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameConstrainValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public void initialize(ValidName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.length() > 5;
    }
}
