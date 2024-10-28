package com.example.LandscapeBooking.controller;

import com.example.LandscapeBooking.model.Customer;
import com.example.LandscapeBooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Map<String, String> payload) {
        String firstName = payload.get("firstname");
        String lastName = payload.get("lastname");
        String address = payload.get("address");
        String city = payload.get("city");
        String phoneNumber = payload.get("phonenumber");
        return new ResponseEntity<Customer>(customerService.createCustomer(firstName,
                                            lastName, address, city, phoneNumber), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Map<String, String> payload) {
        String firstName = payload.get("firstname");
        String lastName = payload.get("lastname");
        String address = payload.get("address");
        String city = payload.get("city");
        String phoneNumber = payload.get("phonenumber");
        return new ResponseEntity<>(customerService.updateCustomer(id, firstName,
                                            lastName, address, city, phoneNumber), HttpStatus.OK);
    }
}
