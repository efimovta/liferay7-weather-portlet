package edu.efimovta.liferay.osgi.weather.dto;

import edu.efimovta.liferay.osgi.weather.dto.impl.WeatherImpl;

/**
 * Gives empty instance
 *
 * @author Efimov Timur
 * @version 1.0.0
 */
public class WeatherFactory {
    /**
     * @return empty instance
     */
    public Weather get() {
        return new WeatherImpl();
    }
}
