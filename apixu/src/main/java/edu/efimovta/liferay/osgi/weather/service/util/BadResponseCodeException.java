package edu.efimovta.liferay.osgi.weather.service.util;

/**
 * If the third-party server returned not 200 status code
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class BadResponseCodeException extends Exception {
    public BadResponseCodeException(String message) {
        super(message);
    }
}
