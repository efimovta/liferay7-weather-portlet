package edu.efimovta.liferay.osgi.weather.service.impl;

import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.dto.WeatherFactory;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Get weather inf from apixu.com - xml
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@Component(immediate = true)
public class ApixuXmlWeatherGetter implements WeatherGetter {

    private final String source = "apixu.com - xml";
    private final String sourceUrl = "http://api.apixu.com/v1/forecast.xml";
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String key = "3579985690364f38a1030507170407";

    /**
     * Get weather forecast from apixu.com - xml
     * for specified longitude, latitude and date
     *
     * @return weather inf
     * @throws WeatherGetterException If any problem occurs while getting weather inf
     */
    public Weather get(double longitude, double latitude, Date date) throws WeatherGetterException {
        try {
            Weather weather;
            String formattedDate = dateFormat.format(date);
            String url = sourceUrl + "?key=" + key + "&q=" + longitude + "," + latitude + "&dt=" + formattedDate;
            weather = getFromXmlSource(url);

            return weather;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new WeatherGetterException(e);
        }
    }

    /**
     * Get weather forecast from apixu.com - xml
     * for specified city and date
     *
     * @return weather inf
     * @throws WeatherGetterException If any problem occurs while getting weather inf
     */
    public Weather get(String city, Date date) throws WeatherGetterException {
        try {
            Weather weather;
            String formattedDate = dateFormat.format(date);
            String url = sourceUrl + "?key=" + key + "&q=" + city + "&dt=" + formattedDate;
            weather = getFromXmlSource(url);

            return weather;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new WeatherGetterException(e);
        }
    }

    private Weather getFromXmlSource(String url) throws ParserConfigurationException, IOException, SAXException {
        Weather weather;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url);
        Element root = document.getDocumentElement();

        Element location = (Element) root.getElementsByTagName("location").item(0);
        Element forecast = (Element) root.getElementsByTagName("forecast").item(0);
        Element forecastday = (Element) forecast.getElementsByTagName("forecastday").item(0);
        Element day = (Element) forecastday.getElementsByTagName("day").item(0);
        Element condition = (Element) day.getElementsByTagName("condition").item(0);

        String city = location.getElementsByTagName("name").item(0).getTextContent();
        String country = location.getElementsByTagName("country").item(0).getTextContent();
        double lat = Double.parseDouble(location.getElementsByTagName("lat").item(0).getTextContent());
        double lon = Double.parseDouble(location.getElementsByTagName("lon").item(0).getTextContent());
        String conditionText = condition.getElementsByTagName("text").item(0).getTextContent();
        double avgtemp_c = Double.parseDouble(day.getElementsByTagName("avgtemp_c").item(0).getTextContent());
        double mintemp_c = Double.parseDouble(day.getElementsByTagName("mintemp_c").item(0).getTextContent());
        double maxtemp_c = Double.parseDouble(day.getElementsByTagName("maxtemp_c").item(0).getTextContent());

        weather = new WeatherFactory().get();
        weather.setSource(source);
        weather.setCity(city);
        weather.setCountry(country);
        weather.setLatitude(lat);
        weather.setLongitude(lon);
        weather.setCondition(conditionText);
        weather.setAvgTemp(avgtemp_c);
        weather.setMinTemp(mintemp_c);
        weather.setMaxTemp(maxtemp_c);

        return weather;
    }
}
