package edu.efimovta.liferay.osgi.weather.dto;

/**
 * Created by eta on 7/5/2017.
 */
public interface Weather {

    String getSource();

    void setSource(String source);

    String getCity();

    void setCity(String city);

    String getCountry();

    void setCountry(String country);

    double getLat();

    void setLat(double lat);

    double getLon();

    void setLon(double lon);

    String getCondition();


    void setCondition(String condition);

    double getAvgTemp();

    void setAvgTemp(double avgTemp);

    double getMinTemp();

    void setMinTemp(double minTemp);

    double getMaxTemp();

    void setMaxTemp(double maxTemp);
}
