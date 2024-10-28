package com.example.LandscapeBooking;

import com.example.LandscapeBooking.model.Team;
import com.example.LandscapeBooking.repository.TeamRepository;
import com.example.LandscapeBooking.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;
    @InjectMocks
    private TeamService teamService;
    private Team testTeam;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        int cityId = 1;
        String teamName = "Team1";
        testTeam = new Team();
        testTeam.setCityID(cityId);
        testTeam.setName(teamName);
    }
    @Test
    public void testFindCityIdAssigned_whenTeamExists_ReturnCityId() {
        String teamName = "Team2";
        int expected = 1;

        when(teamRepository.findByName(teamName)).thenReturn(Optional.of(testTeam));
        Optional<Integer> actual = teamService.findCityIdAssigned(teamName);

        // Assert
        assertTrue(actual.isPresent());
        System.out.println(actual.get());
        assertEquals(expected, actual.get());
    }
}
