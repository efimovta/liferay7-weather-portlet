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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link edu.efimovta.liferay.osgi.db.weather.service.http.WeatherServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see edu.efimovta.liferay.osgi.db.weather.service.http.WeatherServiceSoap
 * @generated
 */
@ProviderType
public class WeatherSoap implements Serializable {
    private long _weatherId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _searchParamCity;
    private Date _searchParamDate;
    private String _source;
    private String _city;
    private String _country;
    private double _lat;
    private double _lon;
    private String _condition;
    private double _avgTemp;
    private double _minTemp;
    private double _maxTemp;
    private Date _date;

    public WeatherSoap() {
    }

    public static WeatherSoap toSoapModel(Weather model) {
        WeatherSoap soapModel = new WeatherSoap();

        soapModel.setWeatherId(model.getWeatherId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setSearchParamCity(model.getSearchParamCity());
        soapModel.setSearchParamDate(model.getSearchParamDate());
        soapModel.setSource(model.getSource());
        soapModel.setCity(model.getCity());
        soapModel.setCountry(model.getCountry());
        soapModel.setLat(model.getLat());
        soapModel.setLon(model.getLon());
        soapModel.setCondition(model.getCondition());
        soapModel.setAvgTemp(model.getAvgTemp());
        soapModel.setMinTemp(model.getMinTemp());
        soapModel.setMaxTemp(model.getMaxTemp());
        soapModel.setDate(model.getDate());

        return soapModel;
    }

    public static WeatherSoap[] toSoapModels(Weather[] models) {
        WeatherSoap[] soapModels = new WeatherSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static WeatherSoap[][] toSoapModels(Weather[][] models) {
        WeatherSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new WeatherSoap[models.length][models[0].length];
        } else {
            soapModels = new WeatherSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static WeatherSoap[] toSoapModels(List<Weather> models) {
        List<WeatherSoap> soapModels = new ArrayList<WeatherSoap>(models.size());

        for (Weather model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new WeatherSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _weatherId;
    }

    public void setPrimaryKey(long pk) {
        setWeatherId(pk);
    }

    public long getWeatherId() {
        return _weatherId;
    }

    public void setWeatherId(long weatherId) {
        _weatherId = weatherId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getSearchParamCity() {
        return _searchParamCity;
    }

    public void setSearchParamCity(String searchParamCity) {
        _searchParamCity = searchParamCity;
    }

    public Date getSearchParamDate() {
        return _searchParamDate;
    }

    public void setSearchParamDate(Date searchParamDate) {
        _searchParamDate = searchParamDate;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public double getLon() {
        return _lon;
    }

    public void setLon(double lon) {
        _lon = lon;
    }

    public String getCondition() {
        return _condition;
    }

    public void setCondition(String condition) {
        _condition = condition;
    }

    public double getAvgTemp() {
        return _avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        _avgTemp = avgTemp;
    }

    public double getMinTemp() {
        return _minTemp;
    }

    public void setMinTemp(double minTemp) {
        _minTemp = minTemp;
    }

    public double getMaxTemp() {
        return _maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        _maxTemp = maxTemp;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }
}