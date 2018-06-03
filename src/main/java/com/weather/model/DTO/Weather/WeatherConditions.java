package com.weather.model.DTO.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherConditions {

    private Coordinates coordinates;
    private Weather[] weather;
    private String base;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Long timeOfDataCalculation;
    private System system;
    private Integer id;
    private String name;
    private Integer code;

    public WeatherConditions() {
    }

    public WeatherConditions(Coordinates coordinates, Weather[] weather, String base, Main main, Wind wind, Clouds clouds, Rain rain, Long timeOfDataCalculation, System system, Integer id, String name, Integer code) {
        this.coordinates = coordinates;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.rain = rain;
        this.timeOfDataCalculation = timeOfDataCalculation;
        this.system = system;
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Long getTimeOfDataCalculation() {
        return timeOfDataCalculation;
    }

    public void setTimeOfDataCalculation(Long timeOfDataCalculation) {
        this.timeOfDataCalculation = timeOfDataCalculation;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "coordinates=" + coordinates +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", rain=" + rain +
                ", timeOfDataCalculation=" + timeOfDataCalculation +
                ", system=" + system +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
