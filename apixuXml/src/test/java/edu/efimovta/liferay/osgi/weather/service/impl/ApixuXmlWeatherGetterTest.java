package edu.efimovta.liferay.osgi.weather.service.impl;

/**
 * @author Efimov Timur
 * @version 1.0.1
 */

import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import edu.efimovta.liferay.osgi.weather.service.configuration.ApixuWeatherConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ApixuXmlWeatherGetterTest {


    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Spy
    private ApixuWeatherConfiguration apixuWeatherConfiguration = new ApixuWeatherConfiguration() {
        @Override
        public String apiKey() {
            return "3579985690364f38a1030507170407";
        }

        @Override
        public String jsonApiUrl() {
            return "http://api.apixu.com/v1/forecast.json";
        }

        @Override
        public String xmlApiUrl() {
            return "http://api.apixu.com/v1/forecast.xml";
        }
    };
    @InjectMocks
    private ApixuWeatherGetter apixuWeatherGetter = new ApixuWeatherGetter();

    @Test
    public void getWeatherForecastForTodayByCity() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get("Moscow", date);

        String date1 = DATE_FORMAT.format(date);
        String date2 = DATE_FORMAT.format(weather.getDate());

        assertTrue(weather.getCity().length() > 0);
        assertTrue(weather.getCondition().length() > 0);
        assertTrue(weather.getMaxTemp() >= weather.getAvgTemp());
        assertTrue(weather.getMinTemp() <= weather.getAvgTemp());
        assertTrue(date1.equals(date2));
    }

    @Test(expected = WeatherGetterException.class)
    public void getWeatherForecastForTodayByInvalidCity() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get("В лесу родилась ёлочка, в лесу она росла.", date);
    }

    @Test
    public void getWeatherForecastForTodayByMoscowCoordinate() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get(37.62, 55.75, date);

        String date1 = DATE_FORMAT.format(date);
        String date2 = DATE_FORMAT.format(weather.getDate());

        assertTrue(weather.getCity().length() > 0);
        assertTrue(weather.getCondition().length() > 0);
        assertTrue(weather.getMaxTemp() >= weather.getAvgTemp());
        assertTrue(weather.getMinTemp() <= weather.getAvgTemp());
        assertTrue(date1.equals(date2));
    }

    @Test(expected = WeatherGetterException.class)
    public void getWeatherForecastForTodayByInvalidCoordinate() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get(0, 0, date);
    }
}