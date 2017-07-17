package edu.efimovta.liferay.osgi.weather.dto.builder;

/**
 * If json from apixu contains not 1 forecastday in array
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class NotValidForecastdayListSizeReceivedException extends Exception {
    public NotValidForecastdayListSizeReceivedException(String message) {
        super(message);
    }
}
