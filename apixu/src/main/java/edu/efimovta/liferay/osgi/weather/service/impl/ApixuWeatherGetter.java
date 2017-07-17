package edu.efimovta.liferay.osgi.weather.service.impl;

import aQute.bnd.annotation.metatype.Configurable;
import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.dto.WeatherFactory;
import edu.efimovta.liferay.osgi.weather.dto.apixu_json_structure.WeatherJsonRoot;
import edu.efimovta.liferay.osgi.weather.dto.builder.ApixuFromJsonStructureWeatherBuilder;
import edu.efimovta.liferay.osgi.weather.dto.builder.NotValidForecastdayListSizeReceivedException;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import edu.efimovta.liferay.osgi.weather.service.configuration.ApixuWeatherConfiguration;
import edu.efimovta.liferay.osgi.weather.service.util.BadResponseCodeException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static edu.efimovta.liferay.osgi.weather.service.util.HttpRequesterUtil.request;

/**
 * Get weather forecast from apixu.com - json.
 *
 * @author Efimov Timur
 * @version 1.0.1
 * @see <a href="https://www.apixu.com/doc/forecast.aspx">https://www.apixu.com/doc/forecast.aspx</a>
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.service.configuration.ApixuWeatherConfiguration",
        immediate = true
)
public class ApixuWeatherGetter implements WeatherGetter {

    private static final Log LOG = LogFactoryUtil.getLog(ApixuWeatherGetter.class);

    private static final String SOURCE_NAME = "apixu.com - json";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /* now in apiConfig */
//    private static final String SOURCE_URL = "http://api.apixu.com/v1/forecast.json";
//    private static final String API_KEY = "3579985690364f38a1030507170407";

    /* url parameters */
    private static final String URL_PARAMETER_API_KEY = "key";
    private static final String URL_PARAMETER_PLACE = "q";
    private static final String URL_PARAMETER_DATE = "dt";

    private volatile ApixuWeatherConfiguration apiConfig;

    /**
     * Get weather forecast from apixu.com - json
     * for specified longitude, latitude and date
     *
     * @return weather forecast
     * @throws WeatherGetterException If any problem occurs while getting weather inf
     */
    public Weather get(double longitude, double latitude, Date date) throws WeatherGetterException {
        Weather weather;
        try {
            String json = getJsonFromSource(longitude, latitude, date);
            weather = parseJson(json);
        } catch (IOException | BadResponseCodeException | NotValidForecastdayListSizeReceivedException e) {
            LOG.error(e, e);
            throw new WeatherGetterException(e);
        }
        return weather;
    }

    /**
     * Get weather forecast from apixu.com - json
     * for specified city and date
     *
     * @param date only yyyy-MM-dd will be taken into, minutes and hours not affect
     * @param city city name
     * @return weather forecast
     * @throws WeatherGetterException If any problem occurs while getting weather forecast
     */
    public Weather get(String city, Date date) throws WeatherGetterException {
        Weather weather;
        try {
            String json = getJsonFromSource(city, date);
            weather = parseJson(json);
        } catch (IOException | BadResponseCodeException | NotValidForecastdayListSizeReceivedException e) {
            LOG.error(e, e);
            throw new WeatherGetterException(e);
        }
        return weather;
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        apiConfig = Configurable.createConfigurable(ApixuWeatherConfiguration.class, properties);
    }

    private String getJsonFromSource(double longitude, double latitude, Date date) throws IOException, BadResponseCodeException {
        String json;
        String formattedDate = DATE_FORMAT.format(date);
        String url = apiConfig.jsonApiUrl() + "?"
                + URL_PARAMETER_API_KEY + "=" + apiConfig.apiKey()
                + "&" + URL_PARAMETER_PLACE + "=" + longitude + "," + latitude
                + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
        url = replaceSpacesWithCode20(url);
        json = request(url);
        return json;
    }

    private String getJsonFromSource(String city, Date date) throws IOException, BadResponseCodeException {
        String json;
        String formattedDate = DATE_FORMAT.format(date);
        String url = apiConfig.jsonApiUrl() + "?"
                + URL_PARAMETER_API_KEY + "=" + apiConfig.apiKey()
                + "&" + URL_PARAMETER_PLACE + "=" + city
                + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
        url = replaceSpacesWithCode20(url);
        json = request(url);
        return json;
    }


    //    private String getJsonFromSource(double longitude, double latitude, Date date) throws IOException, BadResponseCodeException {
//        String json;
//        String formattedDate = DATE_FORMAT.format(date);
//        String url = SOURCE_URL + "?"
//                + URL_PARAMETER_API_KEY + "=" + API_KEY
//                + "&" + URL_PARAMETER_PLACE + "=" + longitude + "," + latitude
//                + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
//        url = replaceSpacesWithCode20(url);
//        json = request(url);
//        return json;
//    }
//
//
//    private String getJsonFromSource(String city, Date date) throws IOException, BadResponseCodeException {
//        String json;
//        String formattedDate = DATE_FORMAT.format(date);
//        String url = SOURCE_URL + "?"
//                + URL_PARAMETER_API_KEY + "=" + API_KEY
//                + "&" + URL_PARAMETER_PLACE + "=" + city
//                + "&" + URL_PARAMETER_DATE + "=" + formattedDate;
//        url = replaceSpacesWithCode20(url);
//        json = request(url);
//        return json;
//    }
//
    private Weather parseJson(String json) throws NotValidForecastdayListSizeReceivedException {
        Weather weather;

        Gson gson = new Gson();
        WeatherJsonRoot weatherJsonRoot = gson.fromJson(json, WeatherJsonRoot.class);
        ApixuFromJsonStructureWeatherBuilder builder = new ApixuFromJsonStructureWeatherBuilder();
        weather = builder.build(weatherJsonRoot);
        weather.setSource(SOURCE_NAME);

        return weather;
    }

    /**
     * not used
     */
    private Weather parseJsonOld(String json) throws JSONException {
        Weather weather;

        JSONObject root = JSONFactoryUtil.createJSONObject(json);
        JSONObject location = root.getJSONObject("location");
        JSONObject forecastday = root.getJSONObject("forecast")
                .getJSONArray("forecastday").getJSONObject(0);
        JSONObject day = forecastday.getJSONObject("day");
        JSONObject condition = day.getJSONObject("condition");

        String city2 = location.getString("name");
        String country = location.getString("country");
        double lat = location.getDouble("lat");
        double lon = location.getDouble("lon");
        long date_epoch = forecastday.getLong("date_epoch");
        String conditionText = condition.getString("text");
        double avgtemp_c = day.getDouble("avgtemp_c");
        double mintemp_c = day.getDouble("mintemp_c");
        double maxtemp_c = day.getDouble("maxtemp_c");

        Date date = new Date((date_epoch - 3 * 60 * 60) * 1000);

        weather = new WeatherFactory().get();
        weather.setSource(SOURCE_NAME);
        weather.setCity(city2);
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

    private String replaceSpacesWithCode20(String url) {
        return url.replace(" ", "%20");
    }

}
