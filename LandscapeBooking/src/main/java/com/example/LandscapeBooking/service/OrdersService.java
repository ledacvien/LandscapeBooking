package com.example.LandscapeBooking.service;

import com.example.LandscapeBooking.model.Orders;
import com.example.LandscapeBooking.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public String checkStatus(int orderNumber) {
        return ordersRepository.checkStatus(orderNumber);
    }

    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders updateStatus(int orderNumber, String status) {
        return ordersRepository.updateStatus(orderNumber, status);
    }

    public Orders createNew(int customerID, int teamID) {
        return ordersRepository.insertOrder(customerID, teamID);
    }
}
