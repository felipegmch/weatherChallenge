package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    private Double rain3h;

    public Rain() {
    }

    public Rain(Double rain3h) {
        this.rain3h = rain3h;
    }

    public Double getRain3h() {
        return rain3h;
    }

    public void setRain3h(Double rain3h) {
        this.rain3h = rain3h;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "rain3h=" + rain3h +
                '}';
    }
}
