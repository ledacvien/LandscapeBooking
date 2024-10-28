package com.example.LandscapeBooking.service;

import com.example.LandscapeBooking.model.City;
import com.example.LandscapeBooking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public int[] findZipcodes(int cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        return city.map(City::getZipcode).orElse(null);
    }

    public int[] findZipcodes(String cityName) {
        Optional<City> city = cityRepository.findByName(cityName);
        return city.map(City::getZipcode).orElse(null);
    }

    public int[] findAllZipcodesByCityId(int cityId) {
        int[] list = cityRepository.findZipCodesByCityId(cityId);
        return cityRepository.findZipCodesByCityId(cityId);
    }

    public int[] findAllZipcodeByCityName(String cityName) {
        return cityRepository.findZipCodesByCityName(cityName);
    }
}
