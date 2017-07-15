package edu.efimovta.liferay.osgi.weather.service;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

import java.util.Date;

/**
 * Service can give weather information from some source
 */
public interface WeatherGetter {
    /**
     * Get weather forecast information from some source for specified longitude, latitude and date
     *
     * @return weather information
     * @throws WeatherGetterException if any problem occurs while getting weather inf
     */
    Weather get(double longitude, double latitude, Date date) throws WeatherGetterException;

    /**
     * Get weather information from some source for specified city and date
     *
     * @return weather information
     * @throws WeatherGetterException if any problem occurs while getting weather inf
     */
    Weather get(String city, Date date) throws WeatherGetterException;
}
