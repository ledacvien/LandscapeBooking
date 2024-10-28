package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Customer;

public interface CustomCustomerRepo {
    Customer insertCustomer(String firstName, String lastName, String address, String phoneNumber, String city);
    Customer updateByID(int customerID, String firstName, String lastName, String address, String city, String phoneNumber);
    Customer deleteByID(int customerID);
}
