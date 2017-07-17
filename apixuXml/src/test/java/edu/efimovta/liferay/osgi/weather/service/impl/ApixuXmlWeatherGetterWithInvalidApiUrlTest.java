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

@RunWith(MockitoJUnitRunner.class)
public class ApixuXmlWeatherGetterWithInvalidApiUrlTest {


    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Spy
    private ApixuWeatherConfiguration apixuWeatherConfiguration = new ApixuWeatherConfiguration() {
        @Override
        public String apiKey() {
            return "3579985690364f38a1030507170407";
        }

        @Override
        public String jsonApiUrl() {
            return "http://api.apixu.com/v1/timur.json";
        }

        @Override
        public String xmlApiUrl() {
            return "http://api.apixu.com/v1/timur.xml";
        }
    };
    @InjectMocks
    private ApixuWeatherGetter apixuWeatherGetter = new ApixuWeatherGetter();

    @Test(expected = WeatherGetterException.class)
    public void getWeatherForecastForTodayByCity() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get("Moscow", date);
    }
}