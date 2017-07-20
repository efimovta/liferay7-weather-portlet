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

package edu.efimovta.liferay.osgi.db.weather.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import edu.efimovta.liferay.osgi.db.weather.exception.NoSuchWeatherException;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;
import edu.efimovta.liferay.osgi.db.weather.service.WeatherLocalServiceUtil;
import edu.efimovta.liferay.osgi.db.weather.service.persistence.WeatherPersistence;
import edu.efimovta.liferay.osgi.db.weather.service.persistence.WeatherUtil;
import org.junit.*;
import org.junit.runner.RunWith;

import java.io.Serializable;
import java.util.*;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class WeatherPersistenceTest {
    @ClassRule
    @Rule
    public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
            PersistenceTestRule.INSTANCE,
            new TransactionalTestRule(Propagation.REQUIRED,
                    "edu.efimovta.liferay.osgi.db.weather.service"));
    private List<Weather> _weathers = new ArrayList<Weather>();
    private WeatherPersistence _persistence;
    private ClassLoader _dynamicQueryClassLoader;

    @Before
    public void setUp() {
        _persistence = WeatherUtil.getPersistence();

        Class<?> clazz = _persistence.getClass();

        _dynamicQueryClassLoader = clazz.getClassLoader();
    }

    @After
    public void tearDown() throws Exception {
        Iterator<Weather> iterator = _weathers.iterator();

        while (iterator.hasNext()) {
            _persistence.remove(iterator.next());

            iterator.remove();
        }
    }

    @Test
    public void testCreate() throws Exception {
        long pk = RandomTestUtil.nextLong();

        Weather weather = _persistence.create(pk);

        Assert.assertNotNull(weather);

        Assert.assertEquals(weather.getPrimaryKey(), pk);
    }

    @Test
    public void testRemove() throws Exception {
        Weather newWeather = addWeather();

        _persistence.remove(newWeather);

        Weather existingWeather = _persistence.fetchByPrimaryKey(newWeather.getPrimaryKey());

        Assert.assertNull(existingWeather);
    }

    @Test
    public void testUpdateNew() throws Exception {
        addWeather();
    }

    @Test
    public void testUpdateExisting() throws Exception {
        long pk = RandomTestUtil.nextLong();

        Weather newWeather = _persistence.create(pk);

        newWeather.setGroupId(RandomTestUtil.nextLong());

        newWeather.setCompanyId(RandomTestUtil.nextLong());

        newWeather.setUserId(RandomTestUtil.nextLong());

        newWeather.setUserName(RandomTestUtil.randomString());

        newWeather.setCreateDate(RandomTestUtil.nextDate());

        newWeather.setModifiedDate(RandomTestUtil.nextDate());

        newWeather.setSearchParamCity(RandomTestUtil.randomString());

        newWeather.setSearchParamDate(RandomTestUtil.nextDate());

        newWeather.setSource(RandomTestUtil.randomString());

        newWeather.setCity(RandomTestUtil.randomString());

        newWeather.setCountry(RandomTestUtil.randomString());

        newWeather.setLat(RandomTestUtil.nextDouble());

        newWeather.setLon(RandomTestUtil.nextDouble());

        newWeather.setCondition(RandomTestUtil.randomString());

        newWeather.setAvgTemp(RandomTestUtil.nextDouble());

        newWeather.setMinTemp(RandomTestUtil.nextDouble());

        newWeather.setMaxTemp(RandomTestUtil.nextDouble());

        newWeather.setDate(RandomTestUtil.nextDate());

        _weathers.add(_persistence.update(newWeather));

        Weather existingWeather = _persistence.findByPrimaryKey(newWeather.getPrimaryKey());

        Assert.assertEquals(existingWeather.getWeatherId(),
                newWeather.getWeatherId());
        Assert.assertEquals(existingWeather.getGroupId(),
                newWeather.getGroupId());
        Assert.assertEquals(existingWeather.getCompanyId(),
                newWeather.getCompanyId());
        Assert.assertEquals(existingWeather.getUserId(), newWeather.getUserId());
        Assert.assertEquals(existingWeather.getUserName(),
                newWeather.getUserName());
        Assert.assertEquals(Time.getShortTimestamp(
                existingWeather.getCreateDate()),
                Time.getShortTimestamp(newWeather.getCreateDate()));
        Assert.assertEquals(Time.getShortTimestamp(
                existingWeather.getModifiedDate()),
                Time.getShortTimestamp(newWeather.getModifiedDate()));
        Assert.assertEquals(existingWeather.getSearchParamCity(),
                newWeather.getSearchParamCity());
        Assert.assertEquals(Time.getShortTimestamp(
                existingWeather.getSearchParamDate()),
                Time.getShortTimestamp(newWeather.getSearchParamDate()));
        Assert.assertEquals(existingWeather.getSource(), newWeather.getSource());
        Assert.assertEquals(existingWeather.getCity(), newWeather.getCity());
        Assert.assertEquals(existingWeather.getCountry(),
                newWeather.getCountry());
        AssertUtils.assertEquals(existingWeather.getLat(), newWeather.getLat());
        AssertUtils.assertEquals(existingWeather.getLon(), newWeather.getLon());
        Assert.assertEquals(existingWeather.getCondition(),
                newWeather.getCondition());
        AssertUtils.assertEquals(existingWeather.getAvgTemp(),
                newWeather.getAvgTemp());
        AssertUtils.assertEquals(existingWeather.getMinTemp(),
                newWeather.getMinTemp());
        AssertUtils.assertEquals(existingWeather.getMaxTemp(),
                newWeather.getMaxTemp());
        Assert.assertEquals(Time.getShortTimestamp(existingWeather.getDate()),
                Time.getShortTimestamp(newWeather.getDate()));
    }

    @Test
    public void testCountByByCityAndDate() throws Exception {
        _persistence.countByByCityAndDate(StringPool.BLANK,
                RandomTestUtil.nextDate());

        _persistence.countByByCityAndDate(StringPool.NULL,
                RandomTestUtil.nextDate());

        _persistence.countByByCityAndDate((String) null,
                RandomTestUtil.nextDate());
    }

    @Test
    public void testCountByByCity() throws Exception {
        _persistence.countByByCity(StringPool.BLANK);

        _persistence.countByByCity(StringPool.NULL);

        _persistence.countByByCity((String) null);
    }

    @Test
    public void testFindByPrimaryKeyExisting() throws Exception {
        Weather newWeather = addWeather();

        Weather existingWeather = _persistence.findByPrimaryKey(newWeather.getPrimaryKey());

        Assert.assertEquals(existingWeather, newWeather);
    }

    @Test(expected = NoSuchWeatherException.class)
    public void testFindByPrimaryKeyMissing() throws Exception {
        long pk = RandomTestUtil.nextLong();

        _persistence.findByPrimaryKey(pk);
    }

    @Test
    public void testFindAll() throws Exception {
        _persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                getOrderByComparator());
    }

    protected OrderByComparator<Weather> getOrderByComparator() {
        return OrderByComparatorFactoryUtil.create("Weatherdb_Weather",
                "weatherId", true, "groupId", true, "companyId", true, "userId",
                true, "userName", true, "createDate", true, "modifiedDate", true,
                "searchParamCity", true, "searchParamDate", true, "source", true,
                "city", true, "country", true, "lat", true, "lon", true,
                "condition", true, "avgTemp", true, "minTemp", true, "maxTemp",
                true, "date", true);
    }

    @Test
    public void testFetchByPrimaryKeyExisting() throws Exception {
        Weather newWeather = addWeather();

        Weather existingWeather = _persistence.fetchByPrimaryKey(newWeather.getPrimaryKey());

        Assert.assertEquals(existingWeather, newWeather);
    }

    @Test
    public void testFetchByPrimaryKeyMissing() throws Exception {
        long pk = RandomTestUtil.nextLong();

        Weather missingWeather = _persistence.fetchByPrimaryKey(pk);

        Assert.assertNull(missingWeather);
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
            throws Exception {
        Weather newWeather1 = addWeather();
        Weather newWeather2 = addWeather();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newWeather1.getPrimaryKey());
        primaryKeys.add(newWeather2.getPrimaryKey());

        Map<Serializable, Weather> weathers = _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(2, weathers.size());
        Assert.assertEquals(newWeather1,
                weathers.get(newWeather1.getPrimaryKey()));
        Assert.assertEquals(newWeather2,
                weathers.get(newWeather2.getPrimaryKey()));
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
            throws Exception {
        long pk1 = RandomTestUtil.nextLong();

        long pk2 = RandomTestUtil.nextLong();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(pk1);
        primaryKeys.add(pk2);

        Map<Serializable, Weather> weathers = _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertTrue(weathers.isEmpty());
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
            throws Exception {
        Weather newWeather = addWeather();

        long pk = RandomTestUtil.nextLong();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newWeather.getPrimaryKey());
        primaryKeys.add(pk);

        Map<Serializable, Weather> weathers = _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(1, weathers.size());
        Assert.assertEquals(newWeather, weathers.get(newWeather.getPrimaryKey()));
    }

    @Test
    public void testFetchByPrimaryKeysWithNoPrimaryKeys()
            throws Exception {
        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        Map<Serializable, Weather> weathers = _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertTrue(weathers.isEmpty());
    }

    @Test
    public void testFetchByPrimaryKeysWithOnePrimaryKey()
            throws Exception {
        Weather newWeather = addWeather();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newWeather.getPrimaryKey());

        Map<Serializable, Weather> weathers = _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(1, weathers.size());
        Assert.assertEquals(newWeather, weathers.get(newWeather.getPrimaryKey()));
    }

    @Test
    public void testActionableDynamicQuery() throws Exception {
        final IntegerWrapper count = new IntegerWrapper();

        ActionableDynamicQuery actionableDynamicQuery = WeatherLocalServiceUtil.getActionableDynamicQuery();

        actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Weather>() {
            @Override
            public void performAction(Weather weather) {
                Assert.assertNotNull(weather);

                count.increment();
            }
        });

        actionableDynamicQuery.performActions();

        Assert.assertEquals(count.getValue(), _persistence.countAll());
    }

    @Test
    public void testDynamicQueryByPrimaryKeyExisting()
            throws Exception {
        Weather newWeather = addWeather();

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Weather.class,
                _dynamicQueryClassLoader);

        dynamicQuery.add(RestrictionsFactoryUtil.eq("weatherId",
                newWeather.getWeatherId()));

        List<Weather> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(1, result.size());

        Weather existingWeather = result.get(0);

        Assert.assertEquals(existingWeather, newWeather);
    }

    @Test
    public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Weather.class,
                _dynamicQueryClassLoader);

        dynamicQuery.add(RestrictionsFactoryUtil.eq("weatherId",
                RandomTestUtil.nextLong()));

        List<Weather> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testDynamicQueryByProjectionExisting()
            throws Exception {
        Weather newWeather = addWeather();

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Weather.class,
                _dynamicQueryClassLoader);

        dynamicQuery.setProjection(ProjectionFactoryUtil.property("weatherId"));

        Object newWeatherId = newWeather.getWeatherId();

        dynamicQuery.add(RestrictionsFactoryUtil.in("weatherId",
                new Object[]{newWeatherId}));

        List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(1, result.size());

        Object existingWeatherId = result.get(0);

        Assert.assertEquals(existingWeatherId, newWeatherId);
    }

    @Test
    public void testDynamicQueryByProjectionMissing() throws Exception {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Weather.class,
                _dynamicQueryClassLoader);

        dynamicQuery.setProjection(ProjectionFactoryUtil.property("weatherId"));

        dynamicQuery.add(RestrictionsFactoryUtil.in("weatherId",
                new Object[]{RandomTestUtil.nextLong()}));

        List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(0, result.size());
    }

    protected Weather addWeather() throws Exception {
        long pk = RandomTestUtil.nextLong();

        Weather weather = _persistence.create(pk);

        weather.setGroupId(RandomTestUtil.nextLong());

        weather.setCompanyId(RandomTestUtil.nextLong());

        weather.setUserId(RandomTestUtil.nextLong());

        weather.setUserName(RandomTestUtil.randomString());

        weather.setCreateDate(RandomTestUtil.nextDate());

        weather.setModifiedDate(RandomTestUtil.nextDate());

        weather.setSearchParamCity(RandomTestUtil.randomString());

        weather.setSearchParamDate(RandomTestUtil.nextDate());

        weather.setSource(RandomTestUtil.randomString());

        weather.setCity(RandomTestUtil.randomString());

        weather.setCountry(RandomTestUtil.randomString());

        weather.setLat(RandomTestUtil.nextDouble());

        weather.setLon(RandomTestUtil.nextDouble());

        weather.setCondition(RandomTestUtil.randomString());

        weather.setAvgTemp(RandomTestUtil.nextDouble());

        weather.setMinTemp(RandomTestUtil.nextDouble());

        weather.setMaxTemp(RandomTestUtil.nextDouble());

        weather.setDate(RandomTestUtil.nextDate());

        _weathers.add(_persistence.update(weather));

        return weather;
    }
}