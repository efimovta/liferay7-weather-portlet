package edu.efimovta.liferay.osgi.weather.printer.service.impl;

import edu.efimovta.liferay.osgi.weather.dto.Weather;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinter;
import edu.efimovta.liferay.osgi.weather.printer.service.WeatherPrinterException;
import org.osgi.service.component.annotations.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Print weather forecast to file "testFile2.txt"
 * in root liferay folder
 */
@Component(immediate = true)
public class FileWeatherPrinter implements WeatherPrinter {
    private final String path = "..//..//testFile2.txt";//todo config

    /**
     * Print weather forecast for one day
     *
     * @param weather day weather forecast
     * @throws WeatherPrinterException If any problem occurs while printing weather
     */
    public void print(Weather weather) throws WeatherPrinterException {
        try {
            FileOutputStream out = new FileOutputStream(path);

            StringBuilder sb = new StringBuilder();

            sb.append("~~~~~~~~~~# " + weather.getSource() + " #~~~~~~~~~~");
            sb.append("\nCity: ").append(weather.getCity());
            sb.append("\ncountry: ").append(weather.getCountry());
            sb.append("\nlatitude, longitude: ").append(weather.getLatitude()).append(", ").append(weather.getLongitude());
            sb.append("\nconditionText: ").append(weather.getCondition());
            sb.append("\nDate: ").append(weather.getDate());
            sb.append("\navgtemp_c: ").append(weather.getAvgTemp());
            sb.append("\nmintemp_c: ").append(weather.getMinTemp());
            sb.append("\nmaxtemp_c: ").append(weather.getMaxTemp());
            sb.append("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            out.write(sb.toString().getBytes());
            out.close();
        } catch (IOException e) {
            throw new WeatherPrinterException(e);
        }

    }

    /**
     * Print weather forecast for days
     *
     * @param weathers weather forecasts list
     * @throws WeatherPrinterException if any print problem occurs
     */
    public void print(List<Weather> weathers) throws WeatherPrinterException {
        try {
            FileOutputStream out = new FileOutputStream(path);
            StringBuilder sb = new StringBuilder();

            for (Weather weather : weathers) {
                sb.append("\n~~~~~~~~~~# " + weather.getSource() + " #~~~~~~~~~~");
                sb.append("\nCity: ").append(weather.getCity());
                sb.append("\ncountry: ").append(weather.getCountry());
                sb.append("\nlat, lon: ").append(weather.getLatitude()).append(", ").append(weather.getLongitude());
                sb.append("\nDate: ").append(weather.getDate());
                sb.append("\nconditionText: ").append(weather.getCondition());
                sb.append("\navgtemp_c: ").append(weather.getAvgTemp());
                sb.append("\nmintemp_c: ").append(weather.getMinTemp());
                sb.append("\nmaxtemp_c: ").append(weather.getMaxTemp());
                sb.append("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }

            out.write(sb.toString().getBytes());
            out.close();
        } catch (IOException e) {
            throw new WeatherPrinterException(e);
        }
    }
}
