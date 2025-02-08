package com.myhamburgerapp.hamburger_restaurant.util;

import org.springframework.stereotype.Component;



@Component
public class CheckoutValidation {
    private static final String TURKISH_PHONE_PATTERN = "^\\+90 \\d{3} \\d{3} \\d{2} \\d{2}$";
    private static final String CREDIT_CARD_PATTERN = "^(?:\\d{4}[-\\s]?){3}\\d{4}$";

    public boolean isEmpty(String firstName, String lastName,String phoneNumber,String creditCardNumber) {
        if (!firstName.isEmpty() &&  !lastName.isEmpty() &&  !phoneNumber.isEmpty() &&  !creditCardNumber.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        if (!phoneNumber.matches(TURKISH_PHONE_PATTERN)) {
            return false;
        }
        return true;
    }

    public boolean isCreditCardValid(String creditCardNumber) {
        if (!creditCardNumber.matches(CREDIT_CARD_PATTERN)) {
            return false;
        }
        return true;
    }
}
