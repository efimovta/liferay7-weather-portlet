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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;

import java.util.Date;

/**
 * The persistence interface for the weather service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see edu.efimovta.liferay.osgi.db.weather.service.persistence.impl.WeatherPersistenceImpl
 * @see WeatherUtil
 * @generated
 */
@ProviderType
public interface WeatherPersistence extends BasePersistence<Weather> {
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WeatherUtil} to access the weather persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

    /**
     * Returns all the weathers where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @return the matching weathers
     */
    public java.util.List<Weather> findByByCityAndDate(java.lang.String city,
                                                       Date date);

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
    public java.util.List<Weather> findByByCityAndDate(java.lang.String city,
                                                       Date date, int start, int end);

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
    public java.util.List<Weather> findByByCityAndDate(java.lang.String city,
                                                       Date date, int start, int end,
                                                       com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator);

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
    public java.util.List<Weather> findByByCityAndDate(java.lang.String city,
                                                       Date date, int start, int end,
                                                       com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator,
                                                       boolean retrieveFromCache);

    /**
     * Returns the first weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    public Weather findByByCityAndDate_First(java.lang.String city, Date date,
                                             com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException;

    /**
     * Returns the first weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather, or <code>null</code> if a matching weather could not be found
     */
    public Weather fetchByByCityAndDate_First(java.lang.String city, Date date,
                                              com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator);

    /**
     * Returns the last weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    public Weather findByByCityAndDate_Last(java.lang.String city, Date date,
                                            com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException;

    /**
     * Returns the last weather in the ordered set where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather, or <code>null</code> if a matching weather could not be found
     */
    public Weather fetchByByCityAndDate_Last(java.lang.String city, Date date,
                                             com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator);

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
    public Weather[] findByByCityAndDate_PrevAndNext(long weatherId,
                                                     java.lang.String city, Date date,
                                                     com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException;

    /**
     * Removes all the weathers where city = &#63; and date = &#63; from the database.
     *
     * @param city the city
     * @param date the date
     */
    public void removeByByCityAndDate(java.lang.String city, Date date);

    /**
     * Returns the number of weathers where city = &#63; and date = &#63;.
     *
     * @param city the city
     * @param date the date
     * @return the number of matching weathers
     */
    public int countByByCityAndDate(java.lang.String city, Date date);

    /**
     * Caches the weather in the entity cache if it is enabled.
     *
     * @param weather the weather
     */
    public void cacheResult(Weather weather);

    /**
     * Caches the weathers in the entity cache if it is enabled.
     *
     * @param weathers the weathers
     */
    public void cacheResult(java.util.List<Weather> weathers);

    /**
     * Creates a new weather with the primary key. Does not add the weather to the database.
     *
     * @param weatherId the primary key for the new weather
     * @return the new weather
     */
    public Weather create(long weatherId);

    /**
     * Removes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param weatherId the primary key of the weather
     * @return the weather that was removed
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    public Weather remove(long weatherId) throws NoSuchWeatherException;

    public Weather updateImpl(Weather weather);

    /**
     * Returns the weather with the primary key or throws a {@link NoSuchWeatherException} if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    public Weather findByPrimaryKey(long weatherId)
            throws NoSuchWeatherException;

    /**
     * Returns the weather with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather, or <code>null</code> if a weather with the primary key could not be found
     */
    public Weather fetchByPrimaryKey(long weatherId);

    @Override
    public java.util.Map<java.io.Serializable, Weather> fetchByPrimaryKeys(
            java.util.Set<java.io.Serializable> primaryKeys);

    /**
     * Returns all the weathers.
     *
     * @return the weathers
     */
    public java.util.List<Weather> findAll();

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
    public java.util.List<Weather> findAll(int start, int end);

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
    public java.util.List<Weather> findAll(int start, int end,
                                           com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator);

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
    public java.util.List<Weather> findAll(int start, int end,
                                           com.liferay.portal.kernel.util.OrderByComparator<Weather> orderByComparator,
                                           boolean retrieveFromCache);

    /**
     * Removes all the weathers from the database.
     */
    public void removeAll();

    /**
     * Returns the number of weathers.
     *
     * @return the number of weathers
     */
    public int countAll();

    @Override
    public java.util.Set<java.lang.String> getBadColumnNames();
}