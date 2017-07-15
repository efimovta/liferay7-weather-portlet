package edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */
public class Location {
    private String name;
    private String country;
    private double lat;
    private double lon;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
