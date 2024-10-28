package com.example.LandscapeBooking.repository;

import com.example.LandscapeBooking.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    // Look for the cityID that teamName is assigned to
    @Query("SELECT t.cityID FROM Team t WHERE t.name = :teamName")
    Optional<Integer> findCityIdAssigned(@Param("teamName") String teamName);

    Optional<Team> findByName(String teamName);
}
