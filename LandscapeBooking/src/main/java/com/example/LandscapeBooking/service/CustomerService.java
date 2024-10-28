package com.example.LandscapeBooking.service;

import com.example.LandscapeBooking.model.Customer;
import com.example.LandscapeBooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(String firstName, String lastName, String address, String city, String phoneNumber) {
        return customerRepository.insertCustomer(firstName, lastName, address, phoneNumber, city);
    }

    public Customer updateCustomer(int customerId, String firstName, String lastName, String address,
                                   String city, String phoneNumber) {
        int val = customerRepository.updateCustomerById(customerId, firstName, lastName, address, city, phoneNumber);
        return (val > 0) ? new Customer(customerId, firstName, lastName, address, phoneNumber, city) : null;
    }
}
