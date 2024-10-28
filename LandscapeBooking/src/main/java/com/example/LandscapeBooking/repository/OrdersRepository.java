package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>, CustomOrderRepo {
    @Query("SELECT status FROM Orders WHERE orderNumber = :orderNumber")
    String checkStatus(@Param("orderNumber") int orderNumber);

//    @Query("INSERT INTO Orders(customerid, teamid, status) VALUES (:customerID, :teamID, 'Scheduled')")
//    Orders insertOrder(@Param("customerID") int customerID, @Param("teamID") int teamID);
}
