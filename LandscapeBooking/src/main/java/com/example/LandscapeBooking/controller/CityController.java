package com.example.LandscapeBooking.controller;

import com.example.LandscapeBooking.model.City;
import com.example.LandscapeBooking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.findAllCities());
    }

    @GetMapping("/zipcodes")
    public ResponseEntity<int[]> getZipcodes(@RequestParam int cityId) {
        int[] zipcodes = cityService.findZipcodes(cityId);
        return ResponseEntity.ok(zipcodes);
    }

    @GetMapping("/zipcodes/cityname")
    public ResponseEntity<int[]> getZipcodes(@RequestParam String cityname) {
        int[] zipcodes = cityService.findZipcodes(cityname);
        return ResponseEntity.ok(zipcodes);
    }
}
