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
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Weather}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Weather
 * @generated
 */
@ProviderType
public class WeatherWrapper implements Weather, ModelWrapper<Weather> {
    private final Weather _weather;

    public WeatherWrapper(Weather weather) {
        _weather = weather;
    }

    @Override
    public Class<?> getModelClass() {
        return Weather.class;
    }

    @Override
    public String getModelClassName() {
        return Weather.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("weatherId", getWeatherId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("searchParamCity", getSearchParamCity());
        attributes.put("searchParamDate", getSearchParamDate());
        attributes.put("source", getSource());
        attributes.put("city", getCity());
        attributes.put("country", getCountry());
        attributes.put("lat", getLat());
        attributes.put("lon", getLon());
        attributes.put("condition", getCondition());
        attributes.put("avgTemp", getAvgTemp());
        attributes.put("minTemp", getMinTemp());
        attributes.put("maxTemp", getMaxTemp());
        attributes.put("date", getDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long weatherId = (Long) attributes.get("weatherId");

        if (weatherId != null) {
            setWeatherId(weatherId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String searchParamCity = (String) attributes.get("searchParamCity");

        if (searchParamCity != null) {
            setSearchParamCity(searchParamCity);
        }

        Date searchParamDate = (Date) attributes.get("searchParamDate");

        if (searchParamDate != null) {
            setSearchParamDate(searchParamDate);
        }

        String source = (String) attributes.get("source");

        if (source != null) {
            setSource(source);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        Double lat = (Double) attributes.get("lat");

        if (lat != null) {
            setLat(lat);
        }

        Double lon = (Double) attributes.get("lon");

        if (lon != null) {
            setLon(lon);
        }

        String condition = (String) attributes.get("condition");

        if (condition != null) {
            setCondition(condition);
        }

        Double avgTemp = (Double) attributes.get("avgTemp");

        if (avgTemp != null) {
            setAvgTemp(avgTemp);
        }

        Double minTemp = (Double) attributes.get("minTemp");

        if (minTemp != null) {
            setMinTemp(minTemp);
        }

        Double maxTemp = (Double) attributes.get("maxTemp");

        if (maxTemp != null) {
            setMaxTemp(maxTemp);
        }

        Date date = (Date) attributes.get("date");

        if (date != null) {
            setDate(date);
        }
    }

    @Override
    public boolean isCachedModel() {
        return _weather.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _weather.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _weather.isEscapedModel();
    }

    @Override
    public boolean isNew() {
        return _weather.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _weather.setNew(n);
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return _weather.getExpandoBridge();
    }

    @Override
    public com.liferay.portal.kernel.model.CacheModel<edu.efimovta.liferay.osgi.db.weather.model.Weather> toCacheModel() {
        return _weather.toCacheModel();
    }

    /**
     * Returns the avg temp of this weather.
     *
     * @return the avg temp of this weather
     */
    @Override
    public double getAvgTemp() {
        return _weather.getAvgTemp();
    }

    /**
     * Sets the avg temp of this weather.
     *
     * @param avgTemp the avg temp of this weather
     */
    @Override
    public void setAvgTemp(double avgTemp) {
        _weather.setAvgTemp(avgTemp);
    }

    /**
     * Returns the lat of this weather.
     *
     * @return the lat of this weather
     */
    @Override
    public double getLat() {
        return _weather.getLat();
    }

    /**
     * Sets the lat of this weather.
     *
     * @param lat the lat of this weather
     */
    @Override
    public void setLat(double lat) {
        _weather.setLat(lat);
    }

    /**
     * Returns the lon of this weather.
     *
     * @return the lon of this weather
     */
    @Override
    public double getLon() {
        return _weather.getLon();
    }

    /**
     * Sets the lon of this weather.
     *
     * @param lon the lon of this weather
     */
    @Override
    public void setLon(double lon) {
        _weather.setLon(lon);
    }

    /**
     * Returns the max temp of this weather.
     *
     * @return the max temp of this weather
     */
    @Override
    public double getMaxTemp() {
        return _weather.getMaxTemp();
    }

    /**
     * Sets the max temp of this weather.
     *
     * @param maxTemp the max temp of this weather
     */
    @Override
    public void setMaxTemp(double maxTemp) {
        _weather.setMaxTemp(maxTemp);
    }

    /**
     * Returns the min temp of this weather.
     *
     * @return the min temp of this weather
     */
    @Override
    public double getMinTemp() {
        return _weather.getMinTemp();
    }

    /**
     * Sets the min temp of this weather.
     *
     * @param minTemp the min temp of this weather
     */
    @Override
    public void setMinTemp(double minTemp) {
        _weather.setMinTemp(minTemp);
    }

    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather toEscapedModel() {
        return new WeatherWrapper(_weather.toEscapedModel());
    }

    @Override
    public edu.efimovta.liferay.osgi.db.weather.model.Weather toUnescapedModel() {
        return new WeatherWrapper(_weather.toUnescapedModel());
    }

    @Override
    public edu.efimovta.liferay.osgi.weather.dto.Weather getWeather() {
        return _weather.getWeather();
    }

    @Override
    public void setWeather(
            edu.efimovta.liferay.osgi.weather.dto.Weather weather) {
        _weather.setWeather(weather);
    }

    @Override
    public int compareTo(
            edu.efimovta.liferay.osgi.db.weather.model.Weather weather) {
        return _weather.compareTo(weather);
    }

    @Override
    public int hashCode() {
        return _weather.hashCode();
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _weather.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        _weather.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public java.lang.Object clone() {
        return new WeatherWrapper((Weather) _weather.clone());
    }

    /**
     * Returns the city of this weather.
     *
     * @return the city of this weather
     */
    @Override
    public java.lang.String getCity() {
        return _weather.getCity();
    }

    /**
     * Sets the city of this weather.
     *
     * @param city the city of this weather
     */
    @Override
    public void setCity(java.lang.String city) {
        _weather.setCity(city);
    }

    /**
     * Returns the condition of this weather.
     *
     * @return the condition of this weather
     */
    @Override
    public java.lang.String getCondition() {
        return _weather.getCondition();
    }

    /**
     * Sets the condition of this weather.
     *
     * @param condition the condition of this weather
     */
    @Override
    public void setCondition(java.lang.String condition) {
        _weather.setCondition(condition);
    }

    /**
     * Returns the country of this weather.
     *
     * @return the country of this weather
     */
    @Override
    public java.lang.String getCountry() {
        return _weather.getCountry();
    }

    /**
     * Sets the country of this weather.
     *
     * @param country the country of this weather
     */
    @Override
    public void setCountry(java.lang.String country) {
        _weather.setCountry(country);
    }

    /**
     * Returns the search param city of this weather.
     *
     * @return the search param city of this weather
     */
    @Override
    public java.lang.String getSearchParamCity() {
        return _weather.getSearchParamCity();
    }

    /**
     * Sets the search param city of this weather.
     *
     * @param searchParamCity the search param city of this weather
     */
    @Override
    public void setSearchParamCity(java.lang.String searchParamCity) {
        _weather.setSearchParamCity(searchParamCity);
    }

    /**
     * Returns the source of this weather.
     *
     * @return the source of this weather
     */
    @Override
    public java.lang.String getSource() {
        return _weather.getSource();
    }

    /**
     * Sets the source of this weather.
     *
     * @param source the source of this weather
     */
    @Override
    public void setSource(java.lang.String source) {
        _weather.setSource(source);
    }

    /**
     * Returns the user name of this weather.
     *
     * @return the user name of this weather
     */
    @Override
    public java.lang.String getUserName() {
        return _weather.getUserName();
    }

    /**
     * Sets the user name of this weather.
     *
     * @param userName the user name of this weather
     */
    @Override
    public void setUserName(java.lang.String userName) {
        _weather.setUserName(userName);
    }

    /**
     * Returns the user uuid of this weather.
     *
     * @return the user uuid of this weather
     */
    @Override
    public java.lang.String getUserUuid() {
        return _weather.getUserUuid();
    }

    /**
     * Sets the user uuid of this weather.
     *
     * @param userUuid the user uuid of this weather
     */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _weather.setUserUuid(userUuid);
    }

    @Override
    public java.lang.String toString() {
        return _weather.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _weather.toXmlString();
    }

    /**
     * Returns the create date of this weather.
     *
     * @return the create date of this weather
     */
    @Override
    public Date getCreateDate() {
        return _weather.getCreateDate();
    }

    /**
     * Sets the create date of this weather.
     *
     * @param createDate the create date of this weather
     */
    @Override
    public void setCreateDate(Date createDate) {
        _weather.setCreateDate(createDate);
    }

    /**
     * Returns the date of this weather.
     *
     * @return the date of this weather
     */
    @Override
    public Date getDate() {
        return _weather.getDate();
    }

    /**
     * Sets the date of this weather.
     *
     * @param date the date of this weather
     */
    @Override
    public void setDate(Date date) {
        _weather.setDate(date);
    }

    /**
     * Returns the modified date of this weather.
     *
     * @return the modified date of this weather
     */
    @Override
    public Date getModifiedDate() {
        return _weather.getModifiedDate();
    }

    /**
     * Sets the modified date of this weather.
     *
     * @param modifiedDate the modified date of this weather
     */
    @Override
    public void setModifiedDate(Date modifiedDate) {
        _weather.setModifiedDate(modifiedDate);
    }

    /**
     * Returns the search param date of this weather.
     *
     * @return the search param date of this weather
     */
    @Override
    public Date getSearchParamDate() {
        return _weather.getSearchParamDate();
    }

    /**
     * Sets the search param date of this weather.
     *
     * @param searchParamDate the search param date of this weather
     */
    @Override
    public void setSearchParamDate(Date searchParamDate) {
        _weather.setSearchParamDate(searchParamDate);
    }

    /**
     * Returns the company ID of this weather.
     *
     * @return the company ID of this weather
     */
    @Override
    public long getCompanyId() {
        return _weather.getCompanyId();
    }

    /**
     * Sets the company ID of this weather.
     *
     * @param companyId the company ID of this weather
     */
    @Override
    public void setCompanyId(long companyId) {
        _weather.setCompanyId(companyId);
    }

    /**
     * Returns the group ID of this weather.
     *
     * @return the group ID of this weather
     */
    @Override
    public long getGroupId() {
        return _weather.getGroupId();
    }

    /**
     * Sets the group ID of this weather.
     *
     * @param groupId the group ID of this weather
     */
    @Override
    public void setGroupId(long groupId) {
        _weather.setGroupId(groupId);
    }

    /**
     * Returns the primary key of this weather.
     *
     * @return the primary key of this weather
     */
    @Override
    public long getPrimaryKey() {
        return _weather.getPrimaryKey();
    }

    /**
     * Sets the primary key of this weather.
     *
     * @param primaryKey the primary key of this weather
     */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _weather.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the user ID of this weather.
     *
     * @return the user ID of this weather
     */
    @Override
    public long getUserId() {
        return _weather.getUserId();
    }

    /**
     * Sets the user ID of this weather.
     *
     * @param userId the user ID of this weather
     */
    @Override
    public void setUserId(long userId) {
        _weather.setUserId(userId);
    }

    /**
     * Returns the weather ID of this weather.
     *
     * @return the weather ID of this weather
     */
    @Override
    public long getWeatherId() {
        return _weather.getWeatherId();
    }

    /**
     * Sets the weather ID of this weather.
     *
     * @param weatherId the weather ID of this weather
     */
    @Override
    public void setWeatherId(long weatherId) {
        _weather.setWeatherId(weatherId);
    }

    @Override
    public void persist() {
        _weather.persist();
    }

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
        _weather.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
            com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
        _weather.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        _weather.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof WeatherWrapper)) {
            return false;
        }

        WeatherWrapper weatherWrapper = (WeatherWrapper) obj;

        if (Objects.equals(_weather, weatherWrapper._weather)) {
            return true;
        }

        return false;
    }

    @Override
    public Weather getWrappedModel() {
        return _weather;
	}

	@Override
    public boolean isEntityCacheEnabled() {
		return _weather.isEntityCacheEnabled();
	}

	@Override
    public boolean isFinderCacheEnabled() {
		return _weather.isFinderCacheEnabled();
	}

	@Override
    public void resetOriginalValues() {
		_weather.resetOriginalValues();
	}
}