package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Customer;
import com.example.LandscapeBooking.model.Orders;
import com.example.LandscapeBooking.model.Team;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomOrderRepoImpl implements CustomOrderRepo{
    @Autowired
    private EntityManager entityManager;
    @Override
    public Orders insertOrder(int customerID, int teamID) {
        Orders orders = new Orders();
        orders.setCustomer(entityManager.getReference(Customer.class, customerID));
        orders.setStatus("Scheduled");
        orders.setTeam(entityManager.getReference(Team.class, teamID));
        entityManager.persist(orders);
        return orders;
    }

    @Override
    public Orders updateStatus(int orderNumber, String status) {
        Orders orders = entityManager.find(Orders.class, orderNumber);
        if (orders != null) {
            orders.setStatus(status);
            entityManager.merge(orders);
        }
        return orders;
    }
}
