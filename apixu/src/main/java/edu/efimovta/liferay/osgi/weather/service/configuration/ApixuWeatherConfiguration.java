package edu.efimovta.liferay.osgi.weather.service.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * OSGI config for ApixuWeather
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@ExtendedObjectClassDefinition(
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM,
        category = "Weather"
)
@Meta.OCD(id = "edu.efimovta.liferay.osgi.weather.service.configuration.ApixuWeatherConfiguration")
public interface ApixuWeatherConfiguration {
    @Meta.AD(deflt = "3579985690364f38a1030507170407", required = false)
    public String apiKey();

    @Meta.AD(deflt = "http://api.apixu.com/v1/forecast.json", required = false)
    public String jsonApiUrl();

    @Meta.AD(deflt = "http://api.apixu.com/v1/forecast.xml", required = false)
    public String xmlApiUrl();
}
