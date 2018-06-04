package com.weather.model.DAO.entities;

import com.weather.model.DTO.City;

import java.util.List;

public interface ICityDAO {
    public void insert(City city);

    public List<City> findAll();

    public List<City> getCitiesTop1000();
}
