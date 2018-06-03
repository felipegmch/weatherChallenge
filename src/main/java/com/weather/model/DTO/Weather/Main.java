package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private Double temperature;
    private Double pressure;
    private Double humidity;
    private Double minTemperature;
    private Double maxTemperature;
    private Double pressureSeaLevel;
    private Double pressureGroundLevel;

    public Main() {
    }

    public Main(Double temperature, Double pressure, Double humidity, Double minTemperature, Double maxTemperature, Double pressureSeaLevel, Double pressureGroundLevel) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.pressureSeaLevel = pressureSeaLevel;
        this.pressureGroundLevel = pressureGroundLevel;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getPressureSeaLevel() {
        return pressureSeaLevel;
    }

    public void setPressureSeaLevel(Double pressureSeaLevel) {
        this.pressureSeaLevel = pressureSeaLevel;
    }

    public Double getPressureGroundLevel() {
        return pressureGroundLevel;
    }

    public void setPressureGroundLevel(Double pressureGroundLevel) {
        this.pressureGroundLevel = pressureGroundLevel;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", pressureSeaLevel=" + pressureSeaLevel +
                ", pressureGroundLevel=" + pressureGroundLevel +
                '}';
    }
}
