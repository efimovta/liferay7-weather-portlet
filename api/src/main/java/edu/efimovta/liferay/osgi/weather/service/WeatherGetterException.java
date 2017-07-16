package edu.efimovta.liferay.osgi.weather.service;

import java.util.Date;

/**
 * If any problem occurs while getting weather inf
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class WeatherGetterException extends Exception {

    public WeatherGetterException() {
    }

    public WeatherGetterException(String message) {
        super(message);
    }

    public WeatherGetterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherGetterException(Throwable cause) {
        super(cause);
    }

    public WeatherGetterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void main(String[] args) {
        System.out.println(new Date(1500238800000L));
    }
}
