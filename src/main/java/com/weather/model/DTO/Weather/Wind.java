package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    private Double speed;
    private Double degrees;

    public Wind() {
    }

    public Wind(Double speed, Double degrees) {
        this.speed = speed;
        this.degrees = degrees;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDegrees() {
        return degrees;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", degrees=" + degrees +
                '}';
    }
}
