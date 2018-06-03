package com.weather.controller;

import com.weather.model.DTO.City;
import com.weather.model.DTO.Weather.WeatherConditions;
import com.weather.service.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getUsers() {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/cities/{id}", method = RequestMethod.GET)
    public WeatherConditions getCityAPIWeather(@PathVariable("id") long id) {
        RestTemplate restTemplate = new RestTemplate();

        String apiKey = "98ff04334ed14fb358049a447c75b236";
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?id=%s&appid=%s", id, apiKey);

        return restTemplate.getForObject(url, WeatherConditions.class);
    }

}
