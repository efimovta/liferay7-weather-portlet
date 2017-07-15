package edu.efimovta.liferay.osgi.weather.printer.service;

/**
 * If any problem occurs while printing weather
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class WeatherPrinterException extends Exception {
    public WeatherPrinterException() {
    }

    public WeatherPrinterException(String message) {
        super(message);
    }

    public WeatherPrinterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherPrinterException(Throwable cause) {
        super(cause);
    }

    public WeatherPrinterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
