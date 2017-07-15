package edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */
public class WeatherJsonRoot {
    private Location location;
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
