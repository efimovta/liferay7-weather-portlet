package edu.efimovta.liferay.osgi.weather.app;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import edu.efimovta.liferay.osgi.weather.service.WeatherGetter;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * App use services for get weather forecast for today for Moscow
 * and print this to file in liferay-root/*.txt
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
@Component(immediate = true)
public class App {

    private static final Log log = LogFactoryUtil.getLog(App.class);

    private volatile List<WeatherGetter> weatherGetters = new ArrayList<>();
    private volatile WeatherPrinter weatherPrinter;

    @Reference(
            name = "refs.WeatherGetter",
            service = WeatherGetter.class,
            cardinality = ReferenceCardinality.AT_LEAST_ONE,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unbindWeatherGetter"
    )
    protected void bindWeatherGetter(WeatherGetter weatherGetter) {
        System.out.println("bindWeatherGetter: " + weatherGetter.getClass());
        this.weatherGetters.add(weatherGetter);
    }

    protected void unbindWeatherGetter(WeatherGetter weatherGetter) {
        System.out.println("unbindWeatherGetter: " + weatherGetter.getClass());
        this.weatherGetters.remove(weatherGetter);
    }

    @Reference(
            name = "refs.WeatherPrinter",
            service = WeatherPrinter.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unbindWeatherPrinter"
    )
    protected void bindWeatherPrinter(WeatherPrinter weatherPrinter) {
        System.out.println("bindWeatherPrinter: " + weatherPrinter.getClass());
        this.weatherPrinter = weatherPrinter;
    }

    protected void unbindWeatherPrinter(WeatherPrinter weatherPrinter) {
        System.out.println("unbindWeatherPrinter: " + weatherPrinter.getClass());
        this.weatherGetters = null;
    }

    @Activate
    public void start(BundleContext context) throws Exception {
        log.info("@Activate App start");

        List<Weather> weathers = new ArrayList<>();
        for (WeatherGetter weatherGetter : weatherGetters) {
            Weather weather = weatherGetter.get("Moscow", new Date());
            weathers.add(weather);
        }
        weatherPrinter.print(weathers);

        log.info("@Activate App end");
    }

}
