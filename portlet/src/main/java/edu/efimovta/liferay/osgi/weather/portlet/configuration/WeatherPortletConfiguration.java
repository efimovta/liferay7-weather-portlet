package edu.efimovta.liferay.osgi.weather.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * OSGI config for Weather Portlet, that configure default city
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@ExtendedObjectClassDefinition(
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM,
        category = "Weather"
)
@Meta.OCD(id = "edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration")
public interface WeatherPortletConfiguration {
    @Meta.AD(deflt = "Moscow", required = false)
    public String city();
}
