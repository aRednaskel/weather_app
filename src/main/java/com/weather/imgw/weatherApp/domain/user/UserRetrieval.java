package com.weather.imgw.weatherApp.domain.user;

import com.weather.imgw.weatherApp.infrastucture.property.BooleanProperties;
import com.weather.imgw.weatherApp.api.user.user.UserDto;
import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;

import java.util.List;
import java.util.Map;

public interface UserRetrieval {

    UserDto findUserByLogin(String login);

    List<WeatherStationDto> getDataFromAllObservedStation(String login);

    Map<String, Map<String, Double>> showObservedStationsWithParams(String login, BooleanProperties weatherProperties);

}
