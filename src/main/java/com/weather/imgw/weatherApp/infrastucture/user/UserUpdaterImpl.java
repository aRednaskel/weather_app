package com.weather.imgw.weatherApp.infrastucture.user;

import com.weather.imgw.weatherApp.domain.user.UserUpdater;
import com.weather.imgw.weatherApp.domain.weather.WeatherStationRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class UserUpdaterImpl implements UserUpdater {

    private final WeatherStationRetrieval weatherStationRetrieval;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void observeWeatherStation(String login, String stationName) {
        userRepository.findByLogin(login)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
        .addObservedWeatherStation(weatherStationRetrieval.findWithStationName(stationName));
    }

    @Transactional
    @Override
    public void doNotObserveWeatherStation(String login,String stationName) {
        userRepository.findByLogin(login)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND))
                .deleteObservedWeatherStation(weatherStationRetrieval.findWithStationName(stationName));
    }
}
