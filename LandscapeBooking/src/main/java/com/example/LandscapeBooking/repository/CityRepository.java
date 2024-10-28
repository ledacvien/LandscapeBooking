package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(value = "SELECT UNNEST(zipcode) FROM City WHERE cityID = :cityId", nativeQuery = true)
    int[] findZipCodesByCityId(@Param("cityId") int cityId);
    @Query("SELECT UNNEST(zipcode) FROM City WHERE name = :cityName")
    int[] findZipCodesByCityName(@Param("cityName") String cityName);

    // JPA auto generate method that return city with given name
    Optional<City> findByName(String cityName);
}
