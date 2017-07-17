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
public class ApixuXmlWeatherGetterWithInvalidApiKeyTest {


    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Spy
    private ApixuWeatherConfiguration apixuWeatherConfiguration = new ApixuWeatherConfiguration() {
        @Override
        public String apiKey() {
            return "EfimovTimur";
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

    @Test(expected = WeatherGetterException.class)
    public void getWeatherForecastForTodayByCity() throws WeatherGetterException {
        Date date = new Date();
        Weather weather = apixuWeatherGetter.get("Moscow", date);
    }
}