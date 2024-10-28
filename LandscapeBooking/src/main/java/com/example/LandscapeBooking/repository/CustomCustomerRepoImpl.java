package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomCustomerRepoImpl implements CustomCustomerRepo{
    @Autowired
    private EntityManager entityManager;
    @Override
    public Customer insertCustomer(String firstName, String lastName, String address, String phoneNumber, String city) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        customer.setCity(city);
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer updateByID(int customerID, String firstName, String lastName, String address, String city, String phoneNumber) {

        return null;
    }

    @Override
    public Customer deleteByID(int customerID) {
        return null;
    }
}
