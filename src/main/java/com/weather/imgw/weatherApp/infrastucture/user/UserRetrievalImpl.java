package com.weather.imgw.weatherApp.infrastucture.user;

import com.weather.imgw.weatherApp.infrastucture.property.BooleanProperties;
import com.weather.imgw.weatherApp.api.user.user.UserDto;
import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.model.user.User;
import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import com.weather.imgw.weatherApp.domain.user.UserRetrieval;
import com.weather.imgw.weatherApp.infrastucture.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
class UserRetrievalImpl implements UserRetrieval {

    private final UserRepository userRepository;

    @Override
    public UserDto findUserByLogin(String login) {
        return DtoMapper.mapUserToDto(
                userRepository.findByLogin(login)
                        .orElseThrow(
                                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND)));
    }
    
    @Override
    public List<WeatherStationDto> getDataFromAllObservedStation(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return DtoMapper.mapWeatherStationToDto(user.getObservedStations());
    }

    @Override
    public Map<String, Map<String, Double>>showObservedStationsWithParams(String login, BooleanProperties weatherProperties) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return choosedPropertiesFromObservedStations(user.getObservedStations(), weatherProperties);
    }

    private Map<String, Map<String, Double>> choosedPropertiesFromObservedStations(Collection<WeatherStation> stationList, BooleanProperties weatherProperties) {
        Map<String, Map<String, Double>> customizedView = new HashMap<>();
        Map<String, Double> propertiesFromStation = new HashMap<>();
        stationList.forEach(weatherStation -> {
            weatherProperties.returnedProperties()
                    .forEach(property ->
                            propertiesFromStation.put(property.getPropertyName(),
                                    property.getProperty(weatherStation)));
            customizedView.put(weatherStation.getStation(), propertiesFromStation);
        });
        return customizedView;
    }
}
