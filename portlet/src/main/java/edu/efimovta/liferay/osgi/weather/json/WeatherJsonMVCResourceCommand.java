package edu.efimovta.liferay.osgi.weather.json;

import com.google.gson.Gson;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import edu.efimovta.liferay.osgi.weather.configuration.WeatherPortletConfiguration;
import edu.efimovta.liferay.osgi.weather.constants.WeatherPortletKeys;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetterException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by eta on 7/13/2017.
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.configuration.WeatherPortletConfiguration",
        property = {
                "javax.portlet.name=" + WeatherPortletKeys.WeatherPortletName,
                "mvc.command.name=/weather/json"
        },
        service = MVCResourceCommand.class
)
public class WeatherJsonMVCResourceCommand implements MVCResourceCommand {

    private volatile WeatherPortletConfiguration weatherPortletConfiguration;

    private static final Log _log = LogFactoryUtil.getLog(
            WeatherJsonMVCResourceCommand.class);

    @Reference
    private WeatherGetter weatherGetter;

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
        boolean wasException = false;
        try {

            String cityDef = weatherPortletConfiguration.city();
            String dateDef = weatherPortletConfiguration.date();
            PortletPreferences preferences = resourceRequest.getPreferences();
            String city = preferences.getValue("city", cityDef);
            String date = preferences.getValue("date", dateDef);

            Weather weather = weatherGetter.get(city, date);

            PrintWriter printWriter = resourceResponse.getWriter();
            Gson gson = new Gson();
            String jsonWeather = gson.toJson(weather);
            printWriter.write(jsonWeather);

        } catch (WeatherGetterException e) {
            _log.error("While weatherGetter.get(city, date);", e);
            wasException=true;
        } catch (IOException e) {
            _log.error(e, e);
            wasException=true;
        }
        return wasException;
    }


    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        weatherPortletConfiguration = ConfigurableUtil.createConfigurable(
                WeatherPortletConfiguration.class, properties);
    }

}