package edu.efimovta.liferay.osgi.weather.printer.service;

import edu.efimovta.liferay.osgi.weather.dto.Weather;

import java.util.List;

/**
 * Service, that can print weather information to file
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public interface WeatherPrinter {

    /**
     * Print weather information for one day
     *
     * @param weather day weather
     * @throws WeatherPrinterException if any print problem occurs
     */
    void print(Weather weather) throws WeatherPrinterException;

    /**
     * Print weather information for days
     *
     * @param weathers weathers list
     * @throws WeatherPrinterException if any print problem occurs
     */
    void print(List<Weather> weathers) throws WeatherPrinterException;
}
