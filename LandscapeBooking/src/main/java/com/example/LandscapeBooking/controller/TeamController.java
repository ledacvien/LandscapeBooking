package com.example.LandscapeBooking.controller;

import com.example.LandscapeBooking.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/{teamName}")
    public ResponseEntity<Optional<Integer>> findCityByIdAssigned(@PathVariable String teamName) {
        Optional<Integer> citId = teamService.findCityIdAssigned(teamName);
        return new ResponseEntity<Optional<Integer>>(citId, HttpStatus.OK);
    }
}
