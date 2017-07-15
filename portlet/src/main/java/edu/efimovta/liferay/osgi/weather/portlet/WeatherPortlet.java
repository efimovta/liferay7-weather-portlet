package edu.efimovta.liferay.osgi.weather.portlet;


import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration;
import edu.efimovta.liferay.osgi.weather.portlet.constants.WeatherPortletKeys;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import org.osgi.service.component.annotations.*;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


/**
 * This portlet simply displays the weather
 * City and date are configurable by preferences
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration",
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
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        String city;
        String dateStr;
        Date date;
        Weather weather = null;

        String cityDef = weatherPortletConfiguration.city();
        Date dateDef = new Date();

        PortletPreferences preferences = renderRequest.getPreferences();
        city = preferences.getValue("city", cityDef);
        dateStr = preferences.getValue("date", null);

        try {
            if (dateStr == null || Objects.equals(dateStr, "")) {
                date = dateDef;
                dateStr = dateFormat.format(dateDef);
            } else {
                date = dateFormat.parse(dateStr);
            }

            weather = weatherGetter.get(city, date);

        } catch (WeatherGetterException e) {
            _log.error("While weatherGetter.get(city, date);", e);
        } catch (ParseException e) {
            _log.error("Can not parse 'date' from PortletPreferences", e);
        }


        renderRequest.setAttribute("city", city);
        renderRequest.setAttribute("date", dateStr);
        renderRequest.setAttribute("weather", weather);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        weatherPortletConfiguration = ConfigurableUtil.createConfigurable(
                WeatherPortletConfiguration.class, properties);
    }

}