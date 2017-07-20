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

package edu.efimovta.liferay.osgi.db.weather.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import edu.efimovta.liferay.osgi.db.weather.model.Weather;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing Weather in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Weather
 * @generated
 */
@ProviderType
public class WeatherCacheModel implements CacheModel<Weather>, Externalizable {
    public long weatherId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String searchParamCity;
    public long searchParamDate;
    public String source;
    public String city;
    public String country;
    public double lat;
    public double lon;
    public String condition;
    public double avgTemp;
    public double minTemp;
    public double maxTemp;
    public long date;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof WeatherCacheModel)) {
            return false;
        }

        WeatherCacheModel weatherCacheModel = (WeatherCacheModel) obj;

        if (weatherId == weatherCacheModel.weatherId) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return HashUtil.hash(0, weatherId);
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

        sb.append("{weatherId=");
        sb.append(weatherId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", searchParamCity=");
        sb.append(searchParamCity);
        sb.append(", searchParamDate=");
        sb.append(searchParamDate);
        sb.append(", source=");
        sb.append(source);
        sb.append(", city=");
        sb.append(city);
        sb.append(", country=");
        sb.append(country);
        sb.append(", lat=");
        sb.append(lat);
        sb.append(", lon=");
        sb.append(lon);
        sb.append(", condition=");
        sb.append(condition);
        sb.append(", avgTemp=");
        sb.append(avgTemp);
        sb.append(", minTemp=");
        sb.append(minTemp);
        sb.append(", maxTemp=");
        sb.append(maxTemp);
        sb.append(", date=");
        sb.append(date);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Weather toEntityModel() {
        WeatherImpl weatherImpl = new WeatherImpl();

        weatherImpl.setWeatherId(weatherId);
        weatherImpl.setGroupId(groupId);
        weatherImpl.setCompanyId(companyId);
        weatherImpl.setUserId(userId);

        if (userName == null) {
            weatherImpl.setUserName(StringPool.BLANK);
        } else {
            weatherImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            weatherImpl.setCreateDate(null);
        } else {
            weatherImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            weatherImpl.setModifiedDate(null);
        } else {
            weatherImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (searchParamCity == null) {
            weatherImpl.setSearchParamCity(StringPool.BLANK);
        } else {
            weatherImpl.setSearchParamCity(searchParamCity);
        }

        if (searchParamDate == Long.MIN_VALUE) {
            weatherImpl.setSearchParamDate(null);
        } else {
            weatherImpl.setSearchParamDate(new Date(searchParamDate));
        }

        if (source == null) {
            weatherImpl.setSource(StringPool.BLANK);
        } else {
            weatherImpl.setSource(source);
        }

        if (city == null) {
            weatherImpl.setCity(StringPool.BLANK);
        } else {
            weatherImpl.setCity(city);
        }

        if (country == null) {
            weatherImpl.setCountry(StringPool.BLANK);
        } else {
            weatherImpl.setCountry(country);
        }

        weatherImpl.setLat(lat);
        weatherImpl.setLon(lon);

        if (condition == null) {
            weatherImpl.setCondition(StringPool.BLANK);
        } else {
            weatherImpl.setCondition(condition);
        }

        weatherImpl.setAvgTemp(avgTemp);
        weatherImpl.setMinTemp(minTemp);
        weatherImpl.setMaxTemp(maxTemp);

        if (date == Long.MIN_VALUE) {
            weatherImpl.setDate(null);
        } else {
            weatherImpl.setDate(new Date(date));
        }

        weatherImpl.resetOriginalValues();

        return weatherImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        weatherId = objectInput.readLong();

        groupId = objectInput.readLong();

        companyId = objectInput.readLong();

        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        searchParamCity = objectInput.readUTF();
        searchParamDate = objectInput.readLong();
        source = objectInput.readUTF();
        city = objectInput.readUTF();
        country = objectInput.readUTF();

        lat = objectInput.readDouble();

        lon = objectInput.readDouble();
        condition = objectInput.readUTF();

        avgTemp = objectInput.readDouble();

        minTemp = objectInput.readDouble();

        maxTemp = objectInput.readDouble();
        date = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
            throws IOException {
        objectOutput.writeLong(weatherId);

        objectOutput.writeLong(groupId);

        objectOutput.writeLong(companyId);

        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (searchParamCity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(searchParamCity);
        }

        objectOutput.writeLong(searchParamDate);

        if (source == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(source);
        }

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        if (country == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(country);
        }

        objectOutput.writeDouble(lat);

        objectOutput.writeDouble(lon);

        if (condition == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(condition);
        }

        objectOutput.writeDouble(avgTemp);

        objectOutput.writeDouble(minTemp);

        objectOutput.writeDouble(maxTemp);
        objectOutput.writeLong(date);
    }
}