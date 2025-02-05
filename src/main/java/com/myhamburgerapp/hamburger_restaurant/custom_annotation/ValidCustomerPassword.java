package com.myhamburgerapp.hamburger_restaurant.custom_annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomPasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCustomerPassword {

    String message() default "Password is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
