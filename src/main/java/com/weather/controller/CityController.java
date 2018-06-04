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

    @RequestMapping(value = "/cities/id", method = RequestMethod.GET)
    public WeatherConditions getWeatherbyCityId(@RequestParam(value = "id") long id,
                                                @RequestParam(value = "units", required = false) String units) {
        RestTemplate restTemplate = new RestTemplate();

        String apiKey = "98ff04334ed14fb358049a447c75b236";
        String weatherUrl = "http://api.openweathermap.org/data/2.5/weather";
        String unitsUrl = units != null ? String.format("&units=%s", units) : "";

        String url = String.format("%s?id=%s%s&appid=%s", weatherUrl, id, unitsUrl, apiKey);

        return restTemplate.getForObject(url, WeatherConditions.class);
    }

    @RequestMapping(value = "/cities/name", method = RequestMethod.GET)
    public WeatherConditions getWeatherbyCityNameAndCountryCode(@RequestParam(value = "cityName") String cityName,
                                                                @RequestParam(value = "countryCode", required = false) String countryCode,
                                                                @RequestParam(value = "units", required = false) String units) {
        RestTemplate restTemplate = new RestTemplate();

        String apiKey = "98ff04334ed14fb358049a447c75b236";
        String weatherUrl = "http://api.openweathermap.org/data/2.5/weather";
        String countryCodeUrl = countryCode != null ? String.format(",%s", countryCode) : "";
        String unitsUrl = units != null ? String.format("&units=%s", units) : "";

        String url = String.format("%s?q=%s%s%s&appid=%s", weatherUrl, cityName, countryCodeUrl, unitsUrl, apiKey);

        return restTemplate.getForObject(url, WeatherConditions.class);
    }

}
