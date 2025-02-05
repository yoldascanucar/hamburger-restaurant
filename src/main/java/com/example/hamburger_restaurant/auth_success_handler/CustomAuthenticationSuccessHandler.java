package com.example.hamburger_restaurant.auth_success_handler;

import com.example.hamburger_restaurant.entity.Customer;
import com.example.hamburger_restaurant.user_details.CustomUserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Customer customer = userDetails.getCustomer();

        if (customer != null) {
            logger.info("User authenticated successfully. Customer ID: {}", customer.getId());
        } else {
            logger.warn("Authenticated user has no associated customer details");
        }

        response.sendRedirect("/");
    }
}
