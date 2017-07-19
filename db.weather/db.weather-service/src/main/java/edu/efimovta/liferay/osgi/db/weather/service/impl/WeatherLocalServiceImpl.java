/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.efimovta.liferay.osgi.db.weather.service.impl;

import edu.efimovta.liferay.osgi.db.weather.service.base.WeatherLocalServiceBaseImpl;

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
}