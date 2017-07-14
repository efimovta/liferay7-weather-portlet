package edu.efimovta.liferay.osgi.weather.portlet;


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import edu.efimovta.liferay.osgi.weather.configuration.WeatherPortletConfiguration;
import edu.efimovta.liferay.osgi.weather.constants.WeatherPortletKeys;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import org.osgi.service.component.annotations.*;

import javax.portlet.*;
import java.io.IOException;
import java.util.Map;

/**
 * This portlet simply displays the weather
 * City and date are configurable by preferences
 *
 * @author eta
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.configuration.WeatherPortletConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=" + WeatherPortletKeys.WeatherPortletName,
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.init-param.edit-template=/edit.jsp",
                "javax.portlet.init-param.edit-guest-template=/edit-guest.jsp",
                "javax.portlet.init-param.help-template=/help.jsp",
                "javax.portlet.init-param.print-template=/print.jsp",
                "javax.portlet.portlet-mode=text/html;view,edit,edit-guest,help,print",
                "javax.portlet.name=" + WeatherPortletKeys.WeatherPortletName,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class WeatherPortlet extends MVCPortlet {

    private static final Log _log = LogFactoryUtil.getLog(WeatherPortlet.class);

    private volatile WeatherPortletConfiguration weatherPortletConfiguration;

    @Reference
    private WeatherGetter weatherGetter;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        includeWeatherAttributes(renderRequest);
        super.doView(renderRequest, renderResponse);
    }

    @Override
    public void doPrint(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        includeWeatherAttributes(renderRequest);
        super.doPrint(renderRequest, renderResponse);
    }

    private void includeWeatherAttributes(RenderRequest renderRequest) {
        String cityDef = weatherPortletConfiguration.city();
        String dateDef = weatherPortletConfiguration.date();
        PortletPreferences preferences = renderRequest.getPreferences();
        String city = preferences.getValue("city", cityDef);
        String date = preferences.getValue("date", dateDef);

        Weather weather = null;
        try {
            weather = weatherGetter.get(city, date);
        } catch (WeatherGetterException e) {
            _log.error("While weatherGetter.get();", e);
        }
        renderRequest.setAttribute("city", city);
        renderRequest.setAttribute("date", date);
        renderRequest.setAttribute("weather", weather);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        weatherPortletConfiguration = ConfigurableUtil.createConfigurable(
                WeatherPortletConfiguration.class, properties);
    }

}