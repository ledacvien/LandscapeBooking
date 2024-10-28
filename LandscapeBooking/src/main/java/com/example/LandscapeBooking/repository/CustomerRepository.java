package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, CustomCustomerRepo {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer SET firstname = :firstname, lastname = :lastname, " +
            "address = :address, city = :city, phonenumber = :phonenumber " +
            "WHERE customerid = :customerId", nativeQuery = true)
    int updateCustomerById(@Param("customerId") int customerId,
                                       @Param("firstname") String firstname,
                                       @Param("lastname") String lastname,
                                       @Param("address") String address,
                                       @Param("city") String city,
                                       @Param("phonenumber") String phonenumber);
}

