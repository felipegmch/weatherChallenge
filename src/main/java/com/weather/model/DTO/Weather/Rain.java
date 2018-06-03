package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    private Double threeLastHours;

    public Rain() {
    }

    public Rain(Double threeLastHours) {
        this.threeLastHours = threeLastHours;
    }

    public Double getThreeLastHours() {
        return threeLastHours;
    }

    public void setThreeLastHours(Double threeLastHours) {
        this.threeLastHours = threeLastHours;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "threeLastHours=" + threeLastHours +
                '}';
    }
}
