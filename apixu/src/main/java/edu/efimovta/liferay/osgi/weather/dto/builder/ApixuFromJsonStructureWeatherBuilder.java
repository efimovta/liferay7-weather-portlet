package edu.efimovta.liferay.osgi.weather.dto.builder;

import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.dto.WeatherFactory;
import edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure.*;

import java.util.Date;
import java.util.List;

/**
 * Build Weather from json structured class
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class ApixuFromJsonStructureWeatherBuilder {

    /**
     * Build Weather from json structured class
     *
     * @param weatherJsonRoot json structured class
     * @return needed weather inf
     */
    public Weather build(WeatherJsonRoot weatherJsonRoot) throws NotValidForecastdayListSizeReceivedException {
        Weather weather = new WeatherFactory().get();

        Location location = weatherJsonRoot.getLocation();
        List<Forecastday> forecastdayList = weatherJsonRoot.getForecast().getForecastday();
        if (forecastdayList.size() != 1) {
            throw new NotValidForecastdayListSizeReceivedException(forecastdayList.size() + " forecastday was returned, 1 expected");
        }
        Forecastday forecastday = forecastdayList.get(0);
        Day day = forecastday.getDay();
        Condition condition = day.getCondition();

        String city = location.getName();
        String country = location.getCountry();
        double lat = location.getLat();
        double lon = location.getLon();
        long date_epoch = forecastday.getDate_epoch();
        String conditionText = condition.getText();
        double avgtemp_c = day.getAvgtemp_c();
        double mintemp_c = day.getMintemp_c();
        double maxtemp_c = day.getMaxtemp_c();


        Date date = new Date((date_epoch - 3 * 60 * 60) * 1000);


        weather.setCity(city);
        weather.setCountry(country);
        weather.setLatitude(lat);
        weather.setLongitude(lon);
        weather.setDate(date);
        weather.setCondition(conditionText);
        weather.setAvgTemp(avgtemp_c);
        weather.setMinTemp(mintemp_c);
        weather.setMaxTemp(maxtemp_c);

        return weather;
    }
}
