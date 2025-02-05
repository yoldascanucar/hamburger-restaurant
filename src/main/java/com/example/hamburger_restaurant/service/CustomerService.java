package com.example.hamburger_restaurant.service;

import com.example.hamburger_restaurant.entity.Customer;
import com.example.hamburger_restaurant.repository.CustomerRepository;
import com.example.hamburger_restaurant.user_details.CustomUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Transactional
    public void addCustomerToDB(Customer customer) {
         customerRepository.saveAndFlush(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String customerMail) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCustomerMail(customerMail);
        return new CustomUserDetails(customer);
    }

    public boolean mailExists(String customerMail) {
      return customerRepository.existsByCustomerMail(customerMail);
    }
}
