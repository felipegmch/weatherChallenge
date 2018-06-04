package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snow {

    private Double snow3h;

    public Snow() {
    }

    public Snow(Double snow3h) {
        this.snow3h = snow3h;
    }

    public Double getSnow3h() {
        return snow3h;
    }

    public void setSnow3h(Double snow3h) {
        this.snow3h = snow3h;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "snow3h=" + snow3h +
                '}';
    }
}
