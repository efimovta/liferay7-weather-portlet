package edu.efimovta.liferay.osgi.weather.dto;

import java.util.Date;

/**
 * Just dto for weather with getter and setters.
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public interface Weather {

    String getSource();

    void setSource(String source);

    String getCity();

    void setCity(String city);

    String getCountry();

    void setCountry(String country);

    double getLat();

    void setLatitude(double lat);

    double getLon();

    void setLongitude(double lon);

    String getCondition();


    void setCondition(String condition);

    double getAvgTemp();

    void setAvgTemp(double avgTemp);

    double getMinTemp();

    void setMinTemp(double minTemp);

    double getMaxTemp();

    void setMaxTemp(double maxTemp);

    Date getDate();

    void setDate(Date date);
}
