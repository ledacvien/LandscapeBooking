package com.example.LandscapeBooking.controller;

import com.example.LandscapeBooking.model.Orders;
import com.example.LandscapeBooking.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(@RequestBody Map<String, Integer> payload){
        int customerID = payload.get("customerid");
        int teamID = payload.get("teamid");
        Orders orders = ordersService.createNew(customerID, teamID);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrder(@RequestBody Map<String, Object> payload) {
        int orderNumber = (int) payload.get("ordernumber");
        String status = (String) payload.get("status");
        Orders orders = ordersService.updateStatus(orderNumber, status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> ordersList = ordersService.findAllOrders();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
