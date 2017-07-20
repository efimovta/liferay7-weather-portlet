/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.efimovta.liferay.osgi.db.weather.service.impl;

import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;
import edu.efimovta.liferay.osgi.db.weather.service.base.WeatherLocalServiceBaseImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the weather local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.efimovta.liferay.osgi.db.weather.service.WeatherLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WeatherLocalServiceBaseImpl
 * @see edu.efimovta.liferay.osgi.db.weather.service.WeatherLocalServiceUtil
 */
public class WeatherLocalServiceImpl extends WeatherLocalServiceBaseImpl {
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link edu.efimovta.liferay.osgi.db.weather.service.WeatherLocalServiceUtil} to access the weather local service.
	 */


    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * Add weather dto with specified search params. Used for cashing result of WeatherGetter.
     *
     * @param city    specified search param
     * @param date    specified search param
     * @param weather weather forecast
     * @see edu.efimovta.liferay.osgi.weather.service.WeatherGetter
     */
    @Indexable(type = IndexableType.REINDEX)
    public void add(String city, Date date, edu.efimovta.liferay.osgi.weather.dto.Weather weather) {
        long i = counterLocalService.increment();

        Weather weatherdb = createWeather(i);

        weatherdb.setSearchParamCity(city);
        weatherdb.setSearchParamDate(date);
        weatherdb.setWeather(weather);

        addWeather(weatherdb);
    }

    public edu.efimovta.liferay.osgi.weather.dto.Weather getByCity(String city) {
        edu.efimovta.liferay.osgi.weather.dto.Weather weather = null;

        List<Weather> weatherdbList = weatherPersistence.findByByCity(city);
        if (weatherdbList.size() > 0) {
            Weather weatherdb = weatherdbList.get(0);
            weather = weatherdb.getWeather();
        }

        return weather;
    }

    public edu.efimovta.liferay.osgi.weather.dto.Weather getByCityAndDate(String city, Date date) {
        edu.efimovta.liferay.osgi.weather.dto.Weather weather = null;

        List<Weather> weatherdbList = weatherPersistence.findByByCityAndDate(city, date);
        if (weatherdbList.size() > 0) {
            Weather weatherdb = weatherdbList.get(0);
            weather = weatherdb.getWeather();
        }

        return weather;
    }
}