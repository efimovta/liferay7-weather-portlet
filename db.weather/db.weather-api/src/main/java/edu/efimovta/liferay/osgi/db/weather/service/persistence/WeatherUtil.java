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

package edu.efimovta.liferay.osgi.db.weather.service.persistence;

import aQute.bnd.annotation.ProviderType;
import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the weather service. This utility wraps {@link edu.efimovta.liferay.osgi.db.weather.service.persistence.impl.WeatherPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WeatherPersistence
 * @see edu.efimovta.liferay.osgi.db.weather.service.persistence.impl.WeatherPersistenceImpl
 * @generated
 */
@ProviderType
public class WeatherUtil {
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

    private static ServiceTracker<WeatherPersistence, WeatherPersistence> _serviceTracker =
            ServiceTrackerFactory.open(WeatherPersistence.class);

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
     */
    public static void clearCache(Weather weather) {
        getPersistence().clearCache(weather);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Weather> findWithDynamicQuery(DynamicQuery dynamicQuery) {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Weather> findWithDynamicQuery(
            DynamicQuery dynamicQuery, int start, int end) {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Weather> findWithDynamicQuery(
            DynamicQuery dynamicQuery, int start, int end,
            OrderByComparator<Weather> orderByComparator) {
        return getPersistence()
                .findWithDynamicQuery(dynamicQuery, start, end,
                        orderByComparator);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
     */
    public static Weather update(Weather weather) {
        return getPersistence().update(weather);
    }

    /**
     * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
     */
    public static Weather update(Weather weather, ServiceContext serviceContext) {
        return getPersistence().update(weather, serviceContext);
    }

    /**
     * Returns all the weathers where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @return the matching weathers
     */
    public static List<Weather> findByByCityAndDate(java.lang.String city,
                                                    Date date) {
        return getPersistence().findByByCityAndDate(city, date);
    }

    /**
     * Returns a range of all the weathers where city = &#63; and date = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param date the date
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @return the range of matching weathers
     */
    public static List<Weather> findByByCityAndDate(java.lang.String city,
                                                    Date date, int start, int end) {
        return getPersistence().findByByCityAndDate(city, date, start, end);
    }

    /**
     * Returns an ordered range of all the weathers where city = &#63; and date = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param date the date
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching weathers
     */
    public static List<Weather> findByByCityAndDate(java.lang.String city,
                                                    Date date, int start, int end,
                                                    OrderByComparator<Weather> orderByComparator) {
        return getPersistence()
                .findByByCityAndDate(city, date, start, end,
                        orderByComparator);
    }

    /**
     * Returns an ordered range of all the weathers where city = &#63; and date = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param date the date
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param retrieveFromCache whether to retrieve from the finder cache
     * @return the ordered range of matching weathers
     */
    public static List<Weather> findByByCityAndDate(java.lang.String city,
                                                    Date date, int start, int end,
                                                    OrderByComparator<Weather> orderByComparator, boolean retrieveFromCache) {
        return getPersistence()
                .findByByCityAndDate(city, date, start, end,
                        orderByComparator, retrieveFromCache);
    }

    /**
     * Returns the first weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    public static Weather findByByCityAndDate_First(java.lang.String city,
                                                    Date date, OrderByComparator<Weather> orderByComparator)
            throws edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException {
        return getPersistence()
                .findByByCityAndDate_First(city, date, orderByComparator);
    }

    /**
     * Returns the first weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather, or <code>null</code> if a matching weather could not be found
     */
    public static Weather fetchByByCityAndDate_First(java.lang.String city,
                                                     Date date, OrderByComparator<Weather> orderByComparator) {
        return getPersistence()
                .fetchByByCityAndDate_First(city, date, orderByComparator);
    }

    /**
     * Returns the last weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    public static Weather findByByCityAndDate_Last(java.lang.String city,
                                                   Date date, OrderByComparator<Weather> orderByComparator)
            throws edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException {
        return getPersistence()
                .findByByCityAndDate_Last(city, date, orderByComparator);
    }

    /**
     * Returns the last weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather, or <code>null</code> if a matching weather could not be found
     */
    public static Weather fetchByByCityAndDate_Last(java.lang.String city,
                                                    Date date, OrderByComparator<Weather> orderByComparator) {
        return getPersistence()
                .fetchByByCityAndDate_Last(city, date, orderByComparator);
    }

    /**
     * Returns the weathers before and after the current weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param weatherId the primary key of the current weather
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    public static Weather[] findByByCityAndDate_PrevAndNext(long weatherId,
                                                            java.lang.String city, Date date,
                                                            OrderByComparator<Weather> orderByComparator)
            throws edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException {
        return getPersistence()
                .findByByCityAndDate_PrevAndNext(weatherId, city, date,
                        orderByComparator);
    }

    /**
     * Removes all the weathers where city = &#63; and date = &#63; from the database.
     *
     * @param city the city
     * @param date the date
     */
    public static void removeByByCityAndDate(java.lang.String city, Date date) {
        getPersistence().removeByByCityAndDate(city, date);
    }

    /**
     * Returns the number of weathers where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @return the number of matching weathers
     */
    public static int countByByCityAndDate(java.lang.String city, Date date) {
        return getPersistence().countByByCityAndDate(city, date);
    }

    /**
     * Caches the weather in the entity cache if it is enabled.
     *
     * @param weather the weather
     */
    public static void cacheResult(Weather weather) {
        getPersistence().cacheResult(weather);
    }

    /**
     * Caches the weathers in the entity cache if it is enabled.
     *
     * @param weathers the weathers
     */
    public static void cacheResult(List<Weather> weathers) {
        getPersistence().cacheResult(weathers);
    }

    /**
     * Creates a new weather with the primary key. Does not add the weather to the database.
     *
     * @param weatherId the primary key for the new weather
     * @return the new weather
     */
    public static Weather create(long weatherId) {
        return getPersistence().create(weatherId);
    }

    /**
     * Removes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param weatherId the primary key of the weather
     * @return the weather that was removed
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    public static Weather remove(long weatherId)
            throws edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException {
        return getPersistence().remove(weatherId);
    }

    public static Weather updateImpl(Weather weather) {
        return getPersistence().updateImpl(weather);
    }

    /**
     * Returns the weather with the primary key or throws a {@link NoSuchWeatherException} if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    public static Weather findByPrimaryKey(long weatherId)
            throws edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException {
        return getPersistence().findByPrimaryKey(weatherId);
    }

    /**
     * Returns the weather with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather, or <code>null</code> if a weather with the primary key could not be found
     */
    public static Weather fetchByPrimaryKey(long weatherId) {
        return getPersistence().fetchByPrimaryKey(weatherId);
    }

    public static java.util.Map<java.io.Serializable, Weather> fetchByPrimaryKeys(
            java.util.Set<java.io.Serializable> primaryKeys) {
        return getPersistence().fetchByPrimaryKeys(primaryKeys);
    }

    /**
     * Returns all the weathers.
     *
     * @return the weathers
     */
    public static List<Weather> findAll() {
        return getPersistence().findAll();
    }

    /**
     * Returns a range of all the weathers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @return the range of weathers
     */
    public static List<Weather> findAll(int start, int end) {
        return getPersistence().findAll(start, end);
    }

    /**
     * Returns an ordered range of all the weathers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of weathers
     */
    public static List<Weather> findAll(int start, int end,
                                        OrderByComparator<Weather> orderByComparator) {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
     * Returns an ordered range of all the weathers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of weathers
     * @param end the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param retrieveFromCache whether to retrieve from the finder cache
     * @return the ordered range of weathers
     */
    public static List<Weather> findAll(int start, int end,
                                        OrderByComparator<Weather> orderByComparator, boolean retrieveFromCache) {
        return getPersistence()
                .findAll(start, end, orderByComparator, retrieveFromCache);
    }

    /**
     * Removes all the weathers from the database.
     */
    public static void removeAll() {
        getPersistence().removeAll();
    }

    /**
     * Returns the number of weathers.
     *
     * @return the number of weathers
     */
    public static int countAll() {
        return getPersistence().countAll();
    }

    public static java.util.Set<java.lang.String> getBadColumnNames() {
        return getPersistence().getBadColumnNames();
    }

    public static WeatherPersistence getPersistence() {
        return _serviceTracker.getService();
    }
}