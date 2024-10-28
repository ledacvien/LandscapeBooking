package com.example.LandscapeBooking;

import com.example.LandscapeBooking.model.City;
import com.example.LandscapeBooking.repository.CityRepository;
import com.example.LandscapeBooking.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

public class CityServiceTest {
    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindZipcodesByCityId() {
        int cityId = 1;
        int[] expected = {85282, 85283, 85284};
        City city = new City();
        city.setZipcode(expected);

        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));
        int[] query = cityService.findZipcodes(cityId);

        for (int num : query) {
            System.out.println(num);
        }

        assertArrayEquals(expected, query);
    }

    @Test
    public void testFindZipcodes() {
        String cityName = "Tempe";
        int[] expected = {85282, 85283, 85284};
        City city = new City();
        city.setZipcode(expected);

        when(cityRepository.findByName(cityName)).thenReturn(Optional.of(city));
        int[] query = cityService.findZipcodes(cityName);

        for (int num : query) {
            System.out.println(num);
        }

        assertArrayEquals(expected, query);
    }
}
