package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snow {

    private Double threeLastHours;

    public Snow() {
    }

    public Snow(Double threeLastHours) {
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
        return "Snow{" +
                "threeLastHours=" + threeLastHours +
                '}';
    }
}
