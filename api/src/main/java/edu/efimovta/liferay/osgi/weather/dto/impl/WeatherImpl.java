package edu.efimovta.liferay.osgi.weather.dto.impl;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

/**
 * Created by eta on 7/5/2017.
 */
public class WeatherImpl implements Weather {
    private String source;
    private String city;
    private String country;
    private double lat;
    private double lon;
    private String condition;
    private double avgTemp;
    private double minTemp;
    private double maxTemp;

    public WeatherImpl(String source, String city, String country, double lat, double lon, String condition, double avgTemp, double minTemp, double maxTemp) {
        this.source = source;
        this.city = city;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.condition = condition;
        this.avgTemp = avgTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public WeatherImpl(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }
}
