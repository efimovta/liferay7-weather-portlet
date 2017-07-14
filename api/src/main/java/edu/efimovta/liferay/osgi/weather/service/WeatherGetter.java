package edu.efimovta.liferay.osgi.weather.service;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

/**
 * Created by eta on 7/5/2017.
 */
public interface WeatherGetter {
    Weather get() throws WeatherGetterException;
    Weather get(String city, String date) throws WeatherGetterException;
}
