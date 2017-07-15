package edu.efimovta.liferay.osgi.weather.dto.impl;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

import java.util.Date;

/**
 * Just dto for weather with getter and setters.
 *
 * @author Efimov Timur
 * @version 1.0.1
 * @see Weather
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
    private Date date;

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

    public void setLatitude(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLongitude(double lon) {
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

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }
}
