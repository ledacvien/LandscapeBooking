package com.example.LandscapeBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordernumber")
    private int orderNumber;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "teamid", referencedColumnName = "teamid")
    private Team team;
}
