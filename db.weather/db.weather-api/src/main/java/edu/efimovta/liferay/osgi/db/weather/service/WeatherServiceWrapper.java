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

package edu.efimovta.liferay.osgi.db.weather.service;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WeatherService}.
 *
 * @author Brian Wing Shun Chan
 * @see WeatherService
 * @generated
 */
@ProviderType
public class WeatherServiceWrapper implements WeatherService,
        ServiceWrapper<WeatherService> {
    private WeatherService _weatherService;

    public WeatherServiceWrapper(WeatherService weatherService) {
        _weatherService = weatherService;
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public java.lang.String getOSGiServiceIdentifier() {
        return _weatherService.getOSGiServiceIdentifier();
    }

    @Override
    public WeatherService getWrappedService() {
        return _weatherService;
    }

    @Override
    public void setWrappedService(WeatherService weatherService) {
        _weatherService = weatherService;
    }
}