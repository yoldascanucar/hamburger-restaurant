package com.myhamburgerapp.hamburger_restaurant.custom_annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomMailValidator implements ConstraintValidator<ValidCustomerMail, String> {

    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?=.{1,255}$)[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z]{2,})+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (value == null || value.trim().isEmpty()) {
            context.buildConstraintViolationWithTemplate("Email is required").addConstraintViolation();
            return false;
        }
        if (!value.matches(EMAIL_REGEX)) {
            context.buildConstraintViolationWithTemplate("Invalid Email Format").addConstraintViolation();
            return false;
        }
        return true;
    }
}
