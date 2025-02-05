package com.myhamburgerapp.hamburger_restaurant.custom_annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomPasswordValidator implements ConstraintValidator<ValidCustomerPassword, String> {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[\\+\\-\\*/])(?=\\S+$).{8,16}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (value == null || value.trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Password is required").addConstraintViolation();
            return false;
        }

        if (value.startsWith("$2a$")) {
            return true;
        }

        if (!value.matches(PASSWORD_REGEX)) {
            context.buildConstraintViolationWithTemplate("8-16 char, at least a number and a special char").addConstraintViolation();
            return false;
        }
        return true;
    }
}
