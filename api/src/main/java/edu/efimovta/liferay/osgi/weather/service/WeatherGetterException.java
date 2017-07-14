package edu.efimovta.liferay.osgi.weather.service;

/**
 * Created by eta on 7/6/2017.
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
}
