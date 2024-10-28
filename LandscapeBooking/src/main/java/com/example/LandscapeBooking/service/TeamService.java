package com.example.LandscapeBooking.service;

import com.example.LandscapeBooking.model.Team;
import com.example.LandscapeBooking.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

//    public Optional<Integer> findCityIdAssigned(String teamName) {
//        return teamRepository.findCityIdAssigned(teamName);
//    }

    public Optional<Integer> findCityIdAssigned(String teamName) {
        Optional<Team> team = teamRepository.findByName(teamName);
        return team.map(Team::getCityID);
    }
}
