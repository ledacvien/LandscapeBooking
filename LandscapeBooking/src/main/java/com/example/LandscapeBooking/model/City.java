package com.example.LandscapeBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "City")
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityID;
    private String name;
    private int[] zip;
//    @ElementCollection
//    @Column(name = "zipcode", columnDefinition = "integer[]")
    private int[] zipcode;
//    @ElementCollection
//    @Column(name = "teamid", columnDefinition = "integer[]")
    private int[] teamId;
}
