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

package edu.efimovta.liferay.osgi.db.weather.model;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Weather service. Represents a row in the &quot;Weatherdb_Weather&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WeatherModel
 * @see edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherImpl
 * @see edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl
 * @generated
 */
@ImplementationClassName("edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherImpl")
@ProviderType
public interface Weather extends WeatherModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public static final Accessor<Weather, Long> WEATHER_ID_ACCESSOR = new Accessor<Weather, Long>() {
        @Override
        public Long get(Weather weather) {
            return weather.getWeatherId();
        }

        @Override
        public Class<Long> getAttributeClass() {
            return Long.class;
        }

        @Override
        public Class<Weather> getTypeClass() {
            return Weather.class;
        }
    };

    public edu.efimovta.liferay.osgi.weather.dto.Weather getWeather();

    public void setWeather(
            edu.efimovta.liferay.osgi.weather.dto.Weather weather);
}