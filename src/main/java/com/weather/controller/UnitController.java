package com.weather.controller;


import com.weather.model.DTO.Unit;
import com.weather.service.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    public List<Unit> getCities() {
        return unitRepository.findAll();
    }
}
