package edu.efimovta.liferay.osgi.weather.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM,
        category = "My configs"
)
@Meta.OCD(id = "edu.efimovta.liferay.osgi.weather.configuration.WeatherPortletConfiguration")
public interface WeatherPortletConfiguration {
    @Meta.AD(deflt = "Moscow", required = false)
    public String city();
    @Meta.AD(deflt = "2017-07-21", required = false)
    public String date();
}
