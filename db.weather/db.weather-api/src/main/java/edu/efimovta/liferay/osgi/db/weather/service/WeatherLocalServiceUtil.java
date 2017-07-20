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

package edu.efimovta.liferay.osgi.db.weather.service;

import aQute.bnd.annotation.ProviderType;
import com.liferay.osgi.util.ServiceTrackerFactory;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Weather. This utility wraps
 * {@link edu.efimovta.liferay.osgi.db.weather.service.impl.WeatherLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WeatherLocalService
 * @see edu.efimovta.liferay.osgi.db.weather.service.base.WeatherLocalServiceBaseImpl
 * @see edu.efimovta.liferay.osgi.db.weather.service.impl.WeatherLocalServiceImpl
 * @generated
 */
@ProviderType
public class WeatherLocalServiceUtil {
    private static ServiceTracker<WeatherLocalService, WeatherLocalService> _serviceTracker =
            ServiceTrackerFactory.open(WeatherLocalService.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link edu.efimovta.liferay.osgi.db.weather.service.impl.WeatherLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
        return getService().getActionableDynamicQuery();
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
        return getService().getIndexableActionableDynamicQuery();
    }

    /**
     * @throws PortalException
     */
    public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
            com.liferay.portal.kernel.model.PersistedModel persistedModel)
            throws com.liferay.portal.kernel.exception.PortalException {
        return getService().deletePersistedModel(persistedModel);
    }

    public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
            java.io.Serializable primaryKeyObj)
            throws com.liferay.portal.kernel.exception.PortalException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
     * Adds the weather to the database. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was added
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather addWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return getService().addWeather(weather);
    }

    /**
     * Creates a new weather with the primary key. Does not add the weather to the database.
     *
     * @param weatherId the primary key for the new weather
     * @return the new weather
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather createWeather(
            long weatherId) {
        return getService().createWeather(weatherId);
    }

    /**
     * Deletes the weather from the database. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was removed
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather deleteWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return getService().deleteWeather(weather);
    }

    /**
     * Deletes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param weatherId the primary key of the weather
     * @return the weather that was removed
     * @throws PortalException if a weather with the primary key could not be found
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather deleteWeather(
            long weatherId)
            throws com.liferay.portal.kernel.exception.PortalException {
        return getService().deleteWeather(weatherId);
    }

    public static edu.efimovta.liferay.osgi.db.weather.model.Weather fetchWeather(
            long weatherId) {
        return getService().fetchWeather(weatherId);
    }

    /**
     * Returns the weather with the primary key.
     *
     * @param weatherId the primary key of the weather
     * @return the weather
     * @throws PortalException if a weather with the primary key could not be found
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather getWeather(
            long weatherId)
            throws com.liferay.portal.kernel.exception.PortalException {
        return getService().getWeather(weatherId);
    }

    /**
     * Updates the weather in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param weather the weather
     * @return the weather that was updated
     */
    public static edu.efimovta.liferay.osgi.db.weather.model.Weather updateWeather(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return getService().updateWeather(weather);
    }

    public static edu.efimovta.liferay.osgi.weather.dto.Weather getByCity(
            java.lang.String city) {
        return getService().getByCity(city);
    }

    public static edu.efimovta.liferay.osgi.weather.dto.Weather getByCityAndDate(
            java.lang.String city, java.util.Date date) {
        return getService().getByCityAndDate(city, date);
    }

    /**
     * Returns the number of weathers.
     *
     * @return the number of weathers
     */
    public static int getWeathersCount() {
        return getService().getWeathersCount();
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    public static java.lang.String getOSGiServiceIdentifier() {
        return getService().getOSGiServiceIdentifier();
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    public static <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start        the lower bound of the range of model instances
     * @param end          the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     */
    public static <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end) {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery      the dynamic query
     * @param start             the lower bound of the range of model instances
     * @param end               the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     */
    public static <T> java.util.List<T> dynamicQuery(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
            int end,
            com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
        return getService()
                .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
    public static java.util.List<edu.efimovta.liferay.osgi.db.weather.model.Weather> getWeathers(
            int start, int end) {
        return getService().getWeathers(start, end);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    public static long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    public static long dynamicQueryCount(
            com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
            com.liferay.portal.kernel.dao.orm.Projection projection) {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

	public static void add(java.lang.String city, java.util.Date date,
                           edu.efimovta.liferay.osgi.weather.dto.Weather weather) {
		getService().add(city, date, weather);
	}

	public static WeatherLocalService getService() {
		return _serviceTracker.getService();
	}
}