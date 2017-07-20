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

package edu.efimovta.liferay.osgi.db.weather.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.spring.extender.service.ServiceReference;
import edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;
import edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherImpl;
import edu.efimovta.liferay.osgi.db.weather.model.impl.WeatherModelImpl;
import edu.efimovta.liferay.osgi.db.weather.service.persistence.WeatherPersistence;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.*;

/**
 * The persistence implementation for the weather service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WeatherPersistence
 * @see edu.efimovta.liferay.osgi.db.weather.service.persistence.WeatherUtil
 * @generated
 */
@ProviderType
public class WeatherPersistenceImpl extends BasePersistenceImpl<Weather>
        implements WeatherPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link WeatherUtil} to access the weather persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = WeatherImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
            ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
            ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCITYANDDATE =
            new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
                    FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByCityAndDate",
                    new String[]{
                            String.class.getName(), Date.class.getName(),

                            Integer.class.getName(), Integer.class.getName(),
                            OrderByComparator.class.getName()
                    });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE =
            new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
                    FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByCityAndDate",
                    new String[]{String.class.getName(), Date.class.getName()},
                    WeatherModelImpl.SEARCHPARAMCITY_COLUMN_BITMASK |
                            WeatherModelImpl.SEARCHPARAMDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BYCITYANDDATE = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByCityAndDate",
            new String[]{String.class.getName(), Date.class.getName()});
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCITY = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByCity",
            new String[]{
                    String.class.getName(),

                    Integer.class.getName(), Integer.class.getName(),
                    OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY =
            new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherModelImpl.FINDER_CACHE_ENABLED, WeatherImpl.class,
                    FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByCity",
                    new String[]{String.class.getName()},
                    WeatherModelImpl.SEARCHPARAMCITY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BYCITY = new FinderPath(WeatherModelImpl.ENTITY_CACHE_ENABLED,
            WeatherModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByCity",
            new String[]{String.class.getName()});
    private static final String _FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_1 = "weather.searchParamCity IS NULL AND ";
    private static final String _FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_2 = "weather.searchParamCity = ? AND ";
    private static final String _FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_3 = "(weather.searchParamCity IS NULL OR weather.searchParamCity = '') AND ";
    private static final String _FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_1 = "weather.searchParamDate IS NULL";
    private static final String _FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_2 = "weather.searchParamDate = ?";
    private static final String _FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_1 = "weather.searchParamCity IS NULL";
    private static final String _FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_2 = "weather.searchParamCity = ?";
    private static final String _FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_3 = "(weather.searchParamCity IS NULL OR weather.searchParamCity = '')";
    private static final String _SQL_SELECT_WEATHER = "SELECT weather FROM Weather weather";
    private static final String _SQL_SELECT_WEATHER_WHERE_PKS_IN = "SELECT weather FROM Weather weather WHERE weatherId IN (";
    private static final String _SQL_SELECT_WEATHER_WHERE = "SELECT weather FROM Weather weather WHERE ";
    private static final String _SQL_COUNT_WEATHER = "SELECT COUNT(weather) FROM Weather weather";
    private static final String _SQL_COUNT_WEATHER_WHERE = "SELECT COUNT(weather) FROM Weather weather WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "weather.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Weather exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Weather exists with the key {";
    private static final Log _log = LogFactoryUtil.getLog(WeatherPersistenceImpl.class);
    private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[]{
            "condition", "date"
    });
    @ServiceReference(type = CompanyProviderWrapper.class)
    protected CompanyProvider companyProvider;
    @ServiceReference(type = EntityCache.class)
    protected EntityCache entityCache;
    @ServiceReference(type = FinderCache.class)
    protected FinderCache finderCache;

    public WeatherPersistenceImpl() {
        setModelClass(Weather.class);

        try {
            Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
                    "_dbColumnNames");

            Map<String, String> dbColumnNames = new HashMap<String, String>();

            dbColumnNames.put("condition", "condition_");
            dbColumnNames.put("date", "date_");

            field.set(this, dbColumnNames);
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e, e);
            }
        }
    }

    /**
     * Returns all the weathers where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     * @return the matching weathers
     */
    @Override
    public List<Weather> findByByCityAndDate(String searchParamCity,
                                             Date searchParamDate) {
        return findByByCityAndDate(searchParamCity, searchParamDate,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the weathers where searchParamCity = &#63; and searchParamDate = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     * @param start           the lower bound of the range of weathers
     * @param end             the upper bound of the range of weathers (not inclusive)
     * @return the range of matching weathers
     */
    @Override
    public List<Weather> findByByCityAndDate(String searchParamCity,
                                             Date searchParamDate, int start, int end) {
        return findByByCityAndDate(searchParamCity, searchParamDate, start,
                end, null);
    }

    /**
     * Returns an ordered range of all the weathers where searchParamCity = &#63; and searchParamDate = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity   the search param city
     * @param searchParamDate   the search param date
     * @param start             the lower bound of the range of weathers
     * @param end               the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching weathers
     */
    @Override
    public List<Weather> findByByCityAndDate(String searchParamCity,
                                             Date searchParamDate, int start, int end,
                                             OrderByComparator<Weather> orderByComparator) {
        return findByByCityAndDate(searchParamCity, searchParamDate, start,
                end, orderByComparator, true);
    }

    /**
     * Returns an ordered range of all the weathers where searchParamCity = &#63; and searchParamDate = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity   the search param city
     * @param searchParamDate   the search param date
     * @param start             the lower bound of the range of weathers
     * @param end               the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param retrieveFromCache whether to retrieve from the finder cache
     * @return the ordered range of matching weathers
     */
    @Override
    public List<Weather> findByByCityAndDate(String searchParamCity,
                                             Date searchParamDate, int start, int end,
                                             OrderByComparator<Weather> orderByComparator, boolean retrieveFromCache) {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE;
            finderArgs = new Object[]{searchParamCity, searchParamDate};
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCITYANDDATE;
            finderArgs = new Object[] {
                    searchParamCity, searchParamDate,

                    start, end, orderByComparator
            };
        }

        List<Weather> list = null;

        if (retrieveFromCache) {
            list = (List<Weather>) finderCache.getResult(finderPath, finderArgs,
                    this);

            if ((list != null) && !list.isEmpty()) {
                for (Weather weather : list) {
                    if (!Objects.equals(searchParamCity,
                            weather.getSearchParamCity()) ||
                            !Objects.equals(searchParamDate,
                                    weather.getSearchParamDate())) {
                        list = null;

                        break;
                    }
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 2));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_WEATHER_WHERE);

            boolean bindSearchParamCity = false;

            if (searchParamCity == null) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_1);
            } else if (searchParamCity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_3);
            } else {
                bindSearchParamCity = true;

                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_2);
            }

            boolean bindSearchParamDate = false;

            if (searchParamDate == null) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_1);
            } else {
                bindSearchParamDate = true;

                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
            } else if (pagination) {
                query.append(WeatherModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSearchParamCity) {
                    qPos.add(searchParamCity);
                }

                if (bindSearchParamDate) {
                    qPos.add(new Timestamp(searchParamDate.getTime()));
                }

                if (!pagination) {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = Collections.unmodifiableList(list);
                } else {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                finderCache.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                finderCache.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first weather in the ordered set where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param searchParamDate   the search param date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    @Override
    public Weather findByByCityAndDate_First(String searchParamCity,
                                             Date searchParamDate, OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = fetchByByCityAndDate_First(searchParamCity,
                searchParamDate, orderByComparator);

        if (weather != null) {
            return weather;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchParamCity=");
        msg.append(searchParamCity);

        msg.append(", searchParamDate=");
        msg.append(searchParamDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWeatherException(msg.toString());
    }

    /**
     * Returns the first weather in the ordered set where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param searchParamDate   the search param date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather, or <code>null</code> if a matching weather could not be found
     */
    @Override
    public Weather fetchByByCityAndDate_First(String searchParamCity,
                                              Date searchParamDate, OrderByComparator<Weather> orderByComparator) {
        List<Weather> list = findByByCityAndDate(searchParamCity,
                searchParamDate, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last weather in the ordered set where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param searchParamDate   the search param date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    @Override
    public Weather findByByCityAndDate_Last(String searchParamCity,
                                            Date searchParamDate, OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = fetchByByCityAndDate_Last(searchParamCity,
                searchParamDate, orderByComparator);

        if (weather != null) {
            return weather;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchParamCity=");
        msg.append(searchParamCity);

        msg.append(", searchParamDate=");
        msg.append(searchParamDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWeatherException(msg.toString());
    }

    /**
     * Returns the last weather in the ordered set where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather, or <code>null</code> if a matching weather could not be found
     */
    @Override
    public Weather fetchByByCityAndDate_Last(String searchParamCity,
                                             Date searchParamDate, OrderByComparator<Weather> orderByComparator) {
        int count = countByByCityAndDate(searchParamCity, searchParamDate);

        if (count == 0) {
            return null;
        }

        List<Weather> list = findByByCityAndDate(searchParamCity,
                searchParamDate, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the weathers before and after the current weather in the ordered set where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param weatherId the primary key of the current weather
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather[] findByByCityAndDate_PrevAndNext(long weatherId,
                                                     String searchParamCity, Date searchParamDate,
                                                     OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = findByPrimaryKey(weatherId);

        Session session = null;

        try {
            session = openSession();

            Weather[] array = new WeatherImpl[3];

            array[0] = getByByCityAndDate_PrevAndNext(session, weather,
                    searchParamCity, searchParamDate, orderByComparator, true);

            array[1] = weather;

            array[2] = getByByCityAndDate_PrevAndNext(session, weather,
                    searchParamCity, searchParamDate, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Weather getByByCityAndDate_PrevAndNext(Session session,
                                                     Weather weather, String searchParamCity, Date searchParamDate,
                                                     OrderByComparator<Weather> orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(5 +
                    (orderByComparator.getOrderByConditionFields().length * 3) +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(4);
        }

        query.append(_SQL_SELECT_WEATHER_WHERE);

        boolean bindSearchParamCity = false;

        if (searchParamCity == null) {
            query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_1);
        } else if (searchParamCity.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_3);
        } else {
            bindSearchParamCity = true;

            query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_2);
        }

        boolean bindSearchParamDate = false;

        if (searchParamDate == null) {
            query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_1);
        } else {
            bindSearchParamDate = true;

            query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(WeatherModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindSearchParamCity) {
            qPos.add(searchParamCity);
        }

        if (bindSearchParamDate) {
            qPos.add(new Timestamp(searchParamDate.getTime()));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(weather);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Weather> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the weathers where searchParamCity = &#63; and searchParamDate = &#63; from the database.
     *
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     */
    @Override
    public void removeByByCityAndDate(String searchParamCity,
                                      Date searchParamDate) {
        for (Weather weather : findByByCityAndDate(searchParamCity,
                searchParamDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(weather);
        }
    }

    /**
     * Returns the number of weathers where searchParamCity = &#63; and searchParamDate = &#63;.
     *
     * @param searchParamCity the search param city
     * @param searchParamDate the search param date
     * @return the number of matching weathers
     */
    @Override
    public int countByByCityAndDate(String searchParamCity, Date searchParamDate) {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BYCITYANDDATE;

        Object[] finderArgs = new Object[]{searchParamCity, searchParamDate};

        Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_WEATHER_WHERE);

            boolean bindSearchParamCity = false;

            if (searchParamCity == null) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_1);
            } else if (searchParamCity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_3);
            } else {
                bindSearchParamCity = true;

                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMCITY_2);
            }

            boolean bindSearchParamDate = false;

            if (searchParamDate == null) {
                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_1);
            } else {
                bindSearchParamDate = true;

                query.append(_FINDER_COLUMN_BYCITYANDDATE_SEARCHPARAMDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSearchParamCity) {
                    qPos.add(searchParamCity);
                }

                if (bindSearchParamDate) {
                    qPos.add(new Timestamp(searchParamDate.getTime()));
                }

                count = (Long) q.uniqueResult();

                finderCache.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                finderCache.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the weathers where searchParamCity = &#63;.
     *
     * @param searchParamCity the search param city
     * @return the matching weathers
     */
    @Override
    public List<Weather> findByByCity(String searchParamCity) {
        return findByByCity(searchParamCity, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the weathers where searchParamCity = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity the search param city
     * @param start           the lower bound of the range of weathers
     * @param end             the upper bound of the range of weathers (not inclusive)
     * @return the range of matching weathers
     */
    @Override
    public List<Weather> findByByCity(String searchParamCity, int start, int end) {
        return findByByCity(searchParamCity, start, end, null);
    }

    /**
     * Returns an ordered range of all the weathers where searchParamCity = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity   the search param city
     * @param start             the lower bound of the range of weathers
     * @param end               the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching weathers
     */
    @Override
    public List<Weather> findByByCity(String searchParamCity, int start,
                                      int end, OrderByComparator<Weather> orderByComparator) {
        return findByByCity(searchParamCity, start, end, orderByComparator, true);
    }

    /**
     * Returns an ordered range of all the weathers where searchParamCity = &#63;.
     * <p>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WeatherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param searchParamCity   the search param city
     * @param start             the lower bound of the range of weathers
     * @param end               the upper bound of the range of weathers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param retrieveFromCache whether to retrieve from the finder cache
     * @return the ordered range of matching weathers
     */
    @Override
    public List<Weather> findByByCity(String searchParamCity, int start,
                                      int end, OrderByComparator<Weather> orderByComparator,
                                      boolean retrieveFromCache) {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY;
            finderArgs = new Object[]{searchParamCity};
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCITY;
            finderArgs = new Object[]{
                    searchParamCity,

                    start, end, orderByComparator
            };
        }

        List<Weather> list = null;

        if (retrieveFromCache) {
            list = (List<Weather>) finderCache.getResult(finderPath, finderArgs,
                    this);

            if ((list != null) && !list.isEmpty()) {
                for (Weather weather : list) {
                    if (!Objects.equals(searchParamCity,
                            weather.getSearchParamCity())) {
                        list = null;

                        break;
                    }
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 2));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_WEATHER_WHERE);

            boolean bindSearchParamCity = false;

            if (searchParamCity == null) {
                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_1);
            } else if (searchParamCity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_3);
            } else {
                bindSearchParamCity = true;

                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);
            } else if (pagination) {
                query.append(WeatherModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSearchParamCity) {
                    qPos.add(searchParamCity);
                }

                if (!pagination) {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = Collections.unmodifiableList(list);
                } else {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                finderCache.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                finderCache.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first weather in the ordered set where searchParamCity = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    @Override
    public Weather findByByCity_First(String searchParamCity,
                                      OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = fetchByByCity_First(searchParamCity, orderByComparator);

        if (weather != null) {
            return weather;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchParamCity=");
        msg.append(searchParamCity);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWeatherException(msg.toString());
    }

    /**
     * Returns the first weather in the ordered set where searchParamCity = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching weather, or <code>null</code> if a matching weather could not be found
     */
    @Override
    public Weather fetchByByCity_First(String searchParamCity,
                                       OrderByComparator<Weather> orderByComparator) {
        List<Weather> list = findByByCity(searchParamCity, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last weather in the ordered set where searchParamCity = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather
     * @throws NoSuchWeatherException if a matching weather could not be found
     */
    @Override
    public Weather findByByCity_Last(String searchParamCity,
                                     OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = fetchByByCity_Last(searchParamCity, orderByComparator);

        if (weather != null) {
            return weather;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("searchParamCity=");
        msg.append(searchParamCity);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchWeatherException(msg.toString());
    }

    /**
     * Returns the last weather in the ordered set where searchParamCity = &#63;.
     *
     * @param searchParamCity   the search param city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching weather, or <code>null</code> if a matching weather could not be found
     */
    @Override
    public Weather fetchByByCity_Last(String searchParamCity,
                                      OrderByComparator<Weather> orderByComparator) {
        int count = countByByCity(searchParamCity);

        if (count == 0) {
            return null;
        }

        List<Weather> list = findByByCity(searchParamCity, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the weathers before and after the current weather in the ordered set where searchParamCity = &#63;.
     *
     * @param weatherId         the primary key of the current weather
     * @param searchParamCity   the search param city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather[] findByByCity_PrevAndNext(long weatherId,
                                              String searchParamCity, OrderByComparator<Weather> orderByComparator)
            throws NoSuchWeatherException {
        Weather weather = findByPrimaryKey(weatherId);

        Session session = null;

        try {
            session = openSession();

            Weather[] array = new WeatherImpl[3];

            array[0] = getByByCity_PrevAndNext(session, weather,
                    searchParamCity, orderByComparator, true);

            array[1] = weather;

            array[2] = getByByCity_PrevAndNext(session, weather,
                    searchParamCity, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Weather getByByCity_PrevAndNext(Session session, Weather weather,
                                              String searchParamCity, OrderByComparator<Weather> orderByComparator,
                                              boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(4 +
                    (orderByComparator.getOrderByConditionFields().length * 3) +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_WEATHER_WHERE);

        boolean bindSearchParamCity = false;

        if (searchParamCity == null) {
            query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_1);
        } else if (searchParamCity.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_3);
        } else {
            bindSearchParamCity = true;

            query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(WeatherModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindSearchParamCity) {
            qPos.add(searchParamCity);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(weather);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Weather> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the weathers where searchParamCity = &#63; from the database.
     *
     * @param searchParamCity the search param city
     */
    @Override
    public void removeByByCity(String searchParamCity) {
        for (Weather weather : findByByCity(searchParamCity, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(weather);
        }
    }

    /**
     * Returns the number of weathers where searchParamCity = &#63;.
     *
     * @param searchParamCity the search param city
     * @return the number of matching weathers
     */
    @Override
    public int countByByCity(String searchParamCity) {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BYCITY;

        Object[] finderArgs = new Object[]{searchParamCity};

        Long count = (Long) finderCache.getResult(finderPath, finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_WEATHER_WHERE);

            boolean bindSearchParamCity = false;

            if (searchParamCity == null) {
                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_1);
            } else if (searchParamCity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_3);
            } else {
                bindSearchParamCity = true;

                query.append(_FINDER_COLUMN_BYCITY_SEARCHPARAMCITY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindSearchParamCity) {
                    qPos.add(searchParamCity);
                }

                count = (Long) q.uniqueResult();

                finderCache.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                finderCache.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the weather in the entity cache if it is enabled.
     *
     * @param weather the weather
     */
    @Override
    public void cacheResult(Weather weather) {
        entityCache.putResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                WeatherImpl.class, weather.getPrimaryKey(), weather);

        weather.resetOriginalValues();
    }

    /**
     * Caches the weathers in the entity cache if it is enabled.
     *
     * @param weathers the weathers
     */
    @Override
    public void cacheResult(List<Weather> weathers) {
        for (Weather weather : weathers) {
            if (entityCache.getResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherImpl.class, weather.getPrimaryKey()) == null) {
                cacheResult(weather);
            } else {
                weather.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all weathers.
     *
     * <p>
     * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        entityCache.clearCache(WeatherImpl.class);

        finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the weather.
     *
     * <p>
     * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Weather weather) {
        entityCache.removeResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                WeatherImpl.class, weather.getPrimaryKey());

        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Weather> weathers) {
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Weather weather : weathers) {
            entityCache.removeResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherImpl.class, weather.getPrimaryKey());
        }
    }

    /**
     * Creates a new weather with the primary key. Does not add the weather to the database.
     *
     * @param weatherId the primary key for the new weather
     * @return the new weather
     */
    @Override
    public Weather create(long weatherId) {
        Weather weather = new WeatherImpl();

        weather.setNew(true);
        weather.setPrimaryKey(weatherId);

        weather.setCompanyId(companyProvider.getCompanyId());

        return weather;
    }

    /**
     * Removes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param weatherId the primary key of the weather
     * @return the weather that was removed
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather remove(long weatherId) throws NoSuchWeatherException {
        return remove((Serializable) weatherId);
    }

    /**
     * Removes the weather with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the weather
     * @return the weather that was removed
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather remove(Serializable primaryKey)
            throws NoSuchWeatherException {
        Session session = null;

        try {
            session = openSession();

            Weather weather = (Weather) session.get(WeatherImpl.class, primaryKey);

            if (weather == null) {
                if (_log.isDebugEnabled()) {
                    _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchWeatherException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                        primaryKey);
            }

            return remove(weather);
        } catch (NoSuchWeatherException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Weather removeImpl(Weather weather) {
        weather = toUnwrappedModel(weather);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(weather)) {
                weather = (Weather) session.get(WeatherImpl.class,
                        weather.getPrimaryKeyObj());
            }

            if (weather != null) {
                session.delete(weather);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (weather != null) {
            clearCache(weather);
        }

        return weather;
    }

    @Override
    public Weather updateImpl(Weather weather) {
        weather = toUnwrappedModel(weather);

        boolean isNew = weather.isNew();

        WeatherModelImpl weatherModelImpl = (WeatherModelImpl) weather;

        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

        Date now = new Date();

        if (isNew && (weather.getCreateDate() == null)) {
            if (serviceContext == null) {
                weather.setCreateDate(now);
            } else {
                weather.setCreateDate(serviceContext.getCreateDate(now));
            }
        }

        if (!weatherModelImpl.hasSetModifiedDate()) {
            if (serviceContext == null) {
                weather.setModifiedDate(now);
            } else {
                weather.setModifiedDate(serviceContext.getModifiedDate(now));
            }
        }

        Session session = null;

        try {
            session = openSession();

            if (weather.isNew()) {
                session.save(weather);

                weather.setNew(false);
            } else {
                weather = (Weather) session.merge(weather);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (!WeatherModelImpl.COLUMN_BITMASK_ENABLED) {
            finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        } else if (isNew) {
            Object[] args = new Object[]{
                    weatherModelImpl.getSearchParamCity(),
                    weatherModelImpl.getSearchParamDate()
            };

            finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITYANDDATE, args);
            finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE,
                    args);

            args = new Object[]{weatherModelImpl.getSearchParamCity()};

            finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITY, args);
            finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY,
                    args);

            finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
            finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
                    FINDER_ARGS_EMPTY);
        } else {
            if ((weatherModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE.getColumnBitmask()) != 0) {
                Object[] args = new Object[]{
                        weatherModelImpl.getOriginalSearchParamCity(),
                        weatherModelImpl.getOriginalSearchParamDate()
                };

                finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITYANDDATE,
                        args);
                finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE,
                        args);

                args = new Object[]{
                        weatherModelImpl.getSearchParamCity(),
                        weatherModelImpl.getSearchParamDate()
                };

                finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITYANDDATE,
                        args);
                finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITYANDDATE,
                        args);
            }

            if ((weatherModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY.getColumnBitmask()) != 0) {
                Object[] args = new Object[]{
                        weatherModelImpl.getOriginalSearchParamCity()
                };

                finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITY, args);
                finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY,
                        args);

                args = new Object[]{weatherModelImpl.getSearchParamCity()};

                finderCache.removeResult(FINDER_PATH_COUNT_BY_BYCITY, args);
                finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCITY,
                        args);
            }
        }

        entityCache.putResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                WeatherImpl.class, weather.getPrimaryKey(), weather, false);

        weather.resetOriginalValues();

        return weather;
    }

    protected Weather toUnwrappedModel(Weather weather) {
        if (weather instanceof WeatherImpl) {
            return weather;
        }

        WeatherImpl weatherImpl = new WeatherImpl();

        weatherImpl.setNew(weather.isNew());
        weatherImpl.setPrimaryKey(weather.getPrimaryKey());

        weatherImpl.setWeatherId(weather.getWeatherId());
        weatherImpl.setGroupId(weather.getGroupId());
        weatherImpl.setCompanyId(weather.getCompanyId());
        weatherImpl.setUserId(weather.getUserId());
        weatherImpl.setUserName(weather.getUserName());
        weatherImpl.setCreateDate(weather.getCreateDate());
        weatherImpl.setModifiedDate(weather.getModifiedDate());
        weatherImpl.setSearchParamCity(weather.getSearchParamCity());
        weatherImpl.setSearchParamDate(weather.getSearchParamDate());
        weatherImpl.setSource(weather.getSource());
        weatherImpl.setCity(weather.getCity());
        weatherImpl.setCountry(weather.getCountry());
        weatherImpl.setLat(weather.getLat());
        weatherImpl.setLon(weather.getLon());
        weatherImpl.setCondition(weather.getCondition());
        weatherImpl.setAvgTemp(weather.getAvgTemp());
        weatherImpl.setMinTemp(weather.getMinTemp());
        weatherImpl.setMaxTemp(weather.getMaxTemp());
        weatherImpl.setDate(weather.getDate());

        return weatherImpl;
    }

    /**
     * Returns the weather with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the weather
     * @return the weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather findByPrimaryKey(Serializable primaryKey)
            throws NoSuchWeatherException {
        Weather weather = fetchByPrimaryKey(primaryKey);

        if (weather == null) {
            if (_log.isDebugEnabled()) {
                _log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchWeatherException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
        }

        return weather;
    }

    /**
     * Returns the weather with the primary key or throws a {@link NoSuchWeatherException} if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather
     * @throws NoSuchWeatherException if a weather with the primary key could not be found
     */
    @Override
    public Weather findByPrimaryKey(long weatherId)
            throws NoSuchWeatherException {
        return findByPrimaryKey((Serializable) weatherId);
    }

    /**
     * Returns the weather with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the weather
     * @return the weather, or <code>null</code> if a weather with the primary key could not be found
     */
    @Override
    public Weather fetchByPrimaryKey(Serializable primaryKey) {
        Serializable serializable = entityCache.getResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                WeatherImpl.class, primaryKey);

        if (serializable == nullModel) {
            return null;
        }

        Weather weather = (Weather) serializable;

        if (weather == null) {
            Session session = null;

            try {
                session = openSession();

                weather = (Weather) session.get(WeatherImpl.class, primaryKey);

                if (weather != null) {
                    cacheResult(weather);
                } else {
                    entityCache.putResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                            WeatherImpl.class, primaryKey, nullModel);
                }
            } catch (Exception e) {
                entityCache.removeResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                        WeatherImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return weather;
    }

    /**
     * Returns the weather with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param weatherId the primary key of the weather
     * @return the weather, or <code>null</code> if a weather with the primary key could not be found
     */
    @Override
    public Weather fetchByPrimaryKey(long weatherId) {
        return fetchByPrimaryKey((Serializable) weatherId);
    }

    @Override
    public Map<Serializable, Weather> fetchByPrimaryKeys(
            Set<Serializable> primaryKeys) {
        if (primaryKeys.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<Serializable, Weather> map = new HashMap<Serializable, Weather>();

        if (primaryKeys.size() == 1) {
            Iterator<Serializable> iterator = primaryKeys.iterator();

            Serializable primaryKey = iterator.next();

            Weather weather = fetchByPrimaryKey(primaryKey);

            if (weather != null) {
                map.put(primaryKey, weather);
            }

            return map;
        }

        Set<Serializable> uncachedPrimaryKeys = null;

        for (Serializable primaryKey : primaryKeys) {
            Serializable serializable = entityCache.getResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                    WeatherImpl.class, primaryKey);

            if (serializable != nullModel) {
                if (serializable == null) {
                    if (uncachedPrimaryKeys == null) {
                        uncachedPrimaryKeys = new HashSet<Serializable>();
                    }

                    uncachedPrimaryKeys.add(primaryKey);
                } else {
                    map.put(primaryKey, (Weather)serializable);
                }
            }
        }

        if (uncachedPrimaryKeys == null) {
            return map;
        }

        StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
                1);

        query.append(_SQL_SELECT_WEATHER_WHERE_PKS_IN);

        for (Serializable primaryKey : uncachedPrimaryKeys) {
            query.append((long) primaryKey);

            query.append(StringPool.COMMA);
        }

        query.setIndex(query.index() - 1);

        query.append(StringPool.CLOSE_PARENTHESIS);

        String sql = query.toString();

        Session session = null;

        try {
            session = openSession();

            Query q = session.createQuery(sql);

            for (Weather weather : (List<Weather>) q.list()) {
                map.put(weather.getPrimaryKeyObj(), weather);

                cacheResult(weather);

                uncachedPrimaryKeys.remove(weather.getPrimaryKeyObj());
            }

            for (Serializable primaryKey : uncachedPrimaryKeys) {
                entityCache.putResult(WeatherModelImpl.ENTITY_CACHE_ENABLED,
                        WeatherImpl.class, primaryKey, nullModel);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        return map;
    }

    /**
     * Returns all the weathers.
     *
     * @return the weathers
     */
    @Override
    public List<Weather> findAll() {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Weather> findAll(int start, int end) {
        return findAll(start, end, null);
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
    @Override
    public List<Weather> findAll(int start, int end,
                                 OrderByComparator<Weather> orderByComparator) {
        return findAll(start, end, orderByComparator, true);
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
    @Override
    public List<Weather> findAll(int start, int end,
                                 OrderByComparator<Weather> orderByComparator, boolean retrieveFromCache) {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[]{start, end, orderByComparator};
        }

        List<Weather> list = null;

        if (retrieveFromCache) {
            list = (List<Weather>) finderCache.getResult(finderPath, finderArgs,
                    this);
        }

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 2));

                query.append(_SQL_SELECT_WEATHER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                        orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_WEATHER;

                if (pagination) {
                    sql = sql.concat(WeatherModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = Collections.unmodifiableList(list);
                } else {
                    list = (List<Weather>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                finderCache.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                finderCache.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the weathers from the database.
     *
     */
    @Override
    public void removeAll() {
        for (Weather weather : findAll()) {
            remove(weather);
        }
    }

    /**
     * Returns the number of weathers.
     *
     * @return the number of weathers
     */
    @Override
    public int countAll() {
        Long count = (Long) finderCache.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_WEATHER);

                count = (Long) q.uniqueResult();

                finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
                        count);
            } catch (Exception e) {
                finderCache.removeResult(FINDER_PATH_COUNT_ALL,
                        FINDER_ARGS_EMPTY);

				throw processException(e);
            }
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
    }

	@Override
    public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
    protected Map<String, Integer> getTableColumnsMap() {
		return WeatherModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
     * Initializes the weather persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
        entityCache.removeCache(WeatherImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}
}