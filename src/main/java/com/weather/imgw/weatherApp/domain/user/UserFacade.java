package com.weather.imgw.weatherApp.domain.user;

import com.weather.imgw.weatherApp.infrastucture.property.BooleanProperties;
import com.weather.imgw.weatherApp.api.user.user.UserDto;
import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserRetrieval userRetrieval;
    private final UserCreator userCreator;
    private final UserUpdater userUpdater;

    public void createUser(UserDto userDto) {
        userCreator.create(userDto);
    }

    public UserDto findUserByLogin(String login) {
        return userRetrieval.findUserByLogin(login);
    }

    public List<WeatherStationDto> showObservedStations(String login) {
        return userRetrieval.getDataFromAllObservedStation(login);
    }

    public Map<String, Map<String, Double>> showObservedStationsWithParams(String login, BooleanProperties weatherProperties){
        return userRetrieval.showObservedStationsWithParams(login, weatherProperties);
    }


    public void addObservedStation(String login, String stationame) {
        userUpdater.observeWeatherStation(login, stationame);
    }

    public void doNotObserveStation(String login, String stationame) {
        userUpdater.doNotObserveWeatherStation(login, stationame);
    }


}
