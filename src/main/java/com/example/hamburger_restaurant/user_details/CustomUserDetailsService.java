package com.example.hamburger_restaurant.user_details;

import com.example.hamburger_restaurant.entity.Customer;
import com.example.hamburger_restaurant.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String customerMail) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCustomerMail(customerMail);
        return new CustomUserDetails(customer);
    }
}
