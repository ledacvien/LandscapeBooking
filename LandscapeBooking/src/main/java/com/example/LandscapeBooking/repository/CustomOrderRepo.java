package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Orders;

public interface CustomOrderRepo {
    Orders insertOrder(int customerID, int teamID);
    Orders updateStatus(int orderNumber, String status);
}
