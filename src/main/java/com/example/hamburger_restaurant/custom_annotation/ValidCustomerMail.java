package com.example.hamburger_restaurant.custom_annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomMailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCustomerMail {
    String message() default "Email is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
