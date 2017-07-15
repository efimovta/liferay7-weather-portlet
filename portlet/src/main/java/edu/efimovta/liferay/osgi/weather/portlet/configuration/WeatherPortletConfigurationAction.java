package edu.efimovta.liferay.osgi.weather.portlet.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import edu.efimovta.liferay.osgi.weather.portlet.constants.WeatherPortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Action on edit preferences for Weather Portlet
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@Component(
        configurationPid = "edu.efimovta.liferay.osgi.weather.portlet.configuration.WeatherPortletConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + WeatherPortletKeys.WeatherPortletName
        },
        service = ConfigurationAction.class
)
public class WeatherPortletConfigurationAction extends DefaultConfigurationAction {

    private static final Log _log = LogFactoryUtil.getLog(WeatherPortletConfigurationAction.class);
    private volatile WeatherPortletConfiguration weatherPortletConfiguration;

    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) throws Exception {

        Date defDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String defDateStr = dateFormat.format(defDate);

        httpServletRequest.setAttribute("cmd", Constants.CMD);
        httpServletRequest.setAttribute("update", Constants.UPDATE);
        httpServletRequest.setAttribute("cityDefault", weatherPortletConfiguration.city());
        httpServletRequest.setAttribute("dateDefault", defDateStr);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        String city = ParamUtil.getString(actionRequest, "city");
        String date = ParamUtil.getString(actionRequest, "date");
        setPreference(actionRequest, "city", city);
        setPreference(actionRequest, "date", date);
        super.processAction(portletConfig, actionRequest, actionResponse);

    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        weatherPortletConfiguration = ConfigurableUtil.createConfigurable(WeatherPortletConfiguration.class, properties);
    }

}
