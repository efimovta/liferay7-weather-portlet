package edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure;

import java.util.List;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */
public class Forecast {
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }
}
