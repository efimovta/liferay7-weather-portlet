package edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */
public class Forecastday {
    private Day day;
    private long date_epoch;

    public long getDate_epoch() {
        return date_epoch;
    }

    public Day getDay() {
        return day;
    }
}
