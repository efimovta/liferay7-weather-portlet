package edu.efimovta.liferay.osgi.weather.service.impl;

import aQute.bnd.annotation.metatype.Configurable;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.dto.WeatherFactory;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import edu.efimovta.liferay.osgi.weather.service.configuration.ApixuWeatherConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
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
import java.util.Map;

/**
 * Get weather inf from apixu.com - xml
 *
 * @author Efimov Timur
 * @version 1.0.1
 * @see <a href="https://www.apixu.com/doc/forecast.aspx">https://www.apixu.com/doc/forecast.aspx</a>
 */
@Component(immediate = true)
public class ApixuXmlWeatherGetter implements WeatherGetter {

    private static final String SOURCE_NAME = "apixu.com - xml";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /* now in apiConfig */
//    private static final String SOURCE_URL = "http://api.apixu.com/v1/forecast.xml";
//    private static final String API_KEY = "3579985690364f38a1030507170407";

    /* url parameters */
    private static final String URL_PARAMETER_API_KEY = "key";
    private static final String URL_PARAMETER_PLACE = "q";
    private static final String URL_PARAMETER_DATE = "dt";

    private volatile ApixuWeatherConfiguration apiConfig;
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
            String formattedDate = DATE_FORMAT.format(date);
            String url = apiConfig.xmlApiUrl() + "?"
                    + URL_PARAMETER_API_KEY + "=" + apiConfig.apiKey()
                    + "&" + URL_PARAMETER_PLACE + "=" + longitude + "," + latitude
                    + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
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
            String formattedDate = DATE_FORMAT.format(date);
            String url = apiConfig.xmlApiUrl() + "?"
                    + URL_PARAMETER_API_KEY + "=" + apiConfig.apiKey()
                    + "&" + URL_PARAMETER_PLACE + "=" + city
                    + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
            weather = getFromXmlSource(url);

            return weather;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new WeatherGetterException(e);
        }
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        apiConfig = Configurable.createConfigurable(ApixuWeatherConfiguration.class, properties);
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
        long date_epoch = Long.parseLong(location.getElementsByTagName("date_epoch").item(0).getTextContent());
        String conditionText = condition.getElementsByTagName("text").item(0).getTextContent();
        double avgtemp_c = Double.parseDouble(day.getElementsByTagName("avgtemp_c").item(0).getTextContent());
        double mintemp_c = Double.parseDouble(day.getElementsByTagName("mintemp_c").item(0).getTextContent());
        double maxtemp_c = Double.parseDouble(day.getElementsByTagName("maxtemp_c").item(0).getTextContent());

        Date date = new Date((date_epoch - 3 * 60 * 60) * 1000);

        weather = new WeatherFactory().get();
        weather.setSource(SOURCE_NAME);
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
