package edu.efimovta.liferay.osgi.weather.portlet.json;

import com.google.gson.Gson;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration;
import edu.efimovta.liferay.osgi.weather.portlet.constants.WeatherPortletKeys;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Provide json resource with weather forecast
 * from specified portlet
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration",
        property = {
                "javax.portlet.name=" + WeatherPortletKeys.WeatherPortletName,
                "mvc.command.name=/weather/json"
        },
        service = MVCResourceCommand.class
)
public class WeatherJsonMVCResourceCommand implements MVCResourceCommand {

    private static final Log _log = LogFactoryUtil.getLog(
            WeatherJsonMVCResourceCommand.class);
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private volatile WeatherPortletConfiguration weatherPortletConfiguration;

    @Reference
    private WeatherGetter weatherGetter;

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
        boolean wasException = false;
        try {
            String cityDef = weatherPortletConfiguration.city();
            Date dateDef = new Date();

            PortletPreferences preferences = resourceRequest.getPreferences();
            String city = preferences.getValue("city", cityDef);
            Date date;
            String dateStr = preferences.getValue("date", null);
            if (dateStr == null) {
                date = dateDef;
            } else {
                date = dateFormat.parse(dateStr);
            }

            Weather weather = weatherGetter.get(city, date);

            PrintWriter printWriter = resourceResponse.getWriter();
            Gson gson = new Gson();
            String jsonWeather = gson.toJson(weather);
            printWriter.write(jsonWeather);

        } catch (WeatherGetterException e) {
            _log.error("While weatherGetter.get(city, date);", e);
            wasException = true;
        } catch (IOException e) {
            _log.error(e, e);
            wasException = true;
        } catch (ParseException e) {
            _log.error("Can not parse 'date' from PortletPreferences", e);
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