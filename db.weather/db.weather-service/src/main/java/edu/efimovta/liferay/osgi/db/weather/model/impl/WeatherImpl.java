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

package edu.efimovta.liferay.osgi.db.weather.model.impl;

import aQute.bnd.annotation.ProviderType;
import edu.efimovta.liferay.osgi.weather.dto.WeatherFactory;

/**
 * The extended model implementation for the Weather service. Represents a row in the &quot;Weatherdb_Weather&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.efimovta.liferay.osgi.db.weather.model.Weather} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class WeatherImpl extends WeatherBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a weather model instance should use the {@link edu.efimovta.liferay.osgi.db.weather.model.Weather} interface instead.
	 */
	public WeatherImpl() {
	}

	public edu.efimovta.liferay.osgi.weather.dto.Weather getWeather() {
		edu.efimovta.liferay.osgi.weather.dto.Weather weather = new WeatherFactory().get();

		weather.setSource(this.getSource());

		weather.setCity(this.getCity());
		weather.setCountry(this.getCountry());
		weather.setLongitude(this.getLon());
		weather.setLatitude(this.getLat());

		weather.setCondition(this.getCondition());
		weather.setMaxTemp(this.getMaxTemp());
		weather.setAvgTemp(this.getAvgTemp());
		weather.setMinTemp(this.getMinTemp());

		weather.setDate(this.getDate());

		return weather;
	}

	public void setWeather(edu.efimovta.liferay.osgi.weather.dto.Weather weather) {

		this.setSource(weather.getSource());

		this.setCity(weather.getCity());
		this.setCountry(weather.getCountry());
		this.setLon(weather.getLongitude());
		this.setLat(weather.getLatitude());

		this.setCondition(weather.getCondition());
		this.setMaxTemp(weather.getMaxTemp());
		this.setAvgTemp(weather.getAvgTemp());
		this.setMinTemp(weather.getMinTemp());

		this.setDate(weather.getDate());
	}
}