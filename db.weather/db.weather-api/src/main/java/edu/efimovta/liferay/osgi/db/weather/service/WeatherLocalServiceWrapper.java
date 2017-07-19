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
 * Provides a wrapper for {@link WeatherLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WeatherLocalService
 * @generated
 */
@ProviderType
public class WeatherLocalServiceWrapper implements WeatherLocalService,
        ServiceWrapper<WeatherLocalService> {
    private WeatherLocalService _weatherLocalService;

    public WeatherLocalServiceWrapper(WeatherLocalService weatherLocalService) {
        _weatherLocalService = weatherLocalService;
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
        return _weatherLocalService.getActionableDynamicQuery();
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _weatherLocalService.dynamicQuery();
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
        return _weatherLocalService.getIndexableActionableDynamicQuery();
    }

    /**
     * @throws PortalException
     */
    @Override
    public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
            com.liferay.portal.kernel.model.PersistedModel persistedModel)
            throws com.liferay.portal.kernel.exception.PortalException {
        return _weatherLocalService.deletePersistedModel(persistedModel);
    }

    @Override
    public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
            java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {
        return _weatherLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
     * Adds the weather to the database. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was added
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather addWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return _weatherLocalService.addWeather(weather);
    }

    /**
     * Creates a new weather with the primary key. Does not add the weather to the database.
     *
     * @param weatherId the primary key for the new weather
     * @return the new weather
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather createWeather(
            long weatherId) {
        return _weatherLocalService.createWeather(weatherId);
    }

    /**
     * Deletes the weather from the database. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was removed
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather deleteWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return _weatherLocalService.deleteWeather(weather);
    }

    /**
     * Deletes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param weatherId the primary key of the weather
     * @return the weather that was removed
     * @throws PortalException if a weather with the primary key could not be found
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather deleteWeather(
            long weatherId)
            throws com.liferay.portal.kernel.exception.PortalException {
        return _weatherLocalService.deleteWeather(weatherId);
    }

    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather fetchWeather(
            long weatherId) {
        return _weatherLocalService.fetchWeather(weatherId);
    }

    /**
     * Returns the weather with the primary key.
     *
     * @param weatherId the primary key of the weather
     * @return the weather
     * @throws PortalException if a weather with the primary key could not be found
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather getWeather(
            long weatherId)
            throws com.liferay.portal.kernel.exception.PortalException {
        return _weatherLocalService.getWeather(weatherId);
    }

    /**
     * Updates the weather in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was updated
     */
    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather updateWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return _weatherLocalService.updateWeather(weather);
    }

    /**
     * Returns the number of weathers.
     *
     * @return the number of weathers
     */
    @Override
    public int getWeathersCount() {
        return _weatherLocalService.getWeathersCount();
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public java.lang.String getOSGiServiceIdentifier() {
        return _weatherLocalService.getOSGiServiceIdentifier();
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
        return _weatherLocalService.dynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end) {
        return _weatherLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     */
    @Override
    public <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
        return _weatherLocalService.dynamicQuery(dynamicQuery, start, end,
                orderByComparator);
    }

    /**
     * Returns a range of all the weathers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @return the range of weathers
     */
    @Override
    public java.util.List<edu.efimovta.liferay.osgi.db.weather.model.Weather> getWeathers(
            int start, int end) {
        return _weatherLocalService.getWeathers(start, end);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
        return _weatherLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
            com.liferay.portal.kernel.dao.orm.Projection projection) {
        return _weatherLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public WeatherLocalService getWrappedService() {
        return _weatherLocalService;
    }

    @Override
    public void setWrappedService(WeatherLocalService weatherLocalService) {
        _weatherLocalService = weatherLocalService;
    }
}