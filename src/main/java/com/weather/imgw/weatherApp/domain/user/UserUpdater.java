package com.weather.imgw.weatherApp.domain.user;

public interface UserUpdater {

    void observeWeatherStation(String login, String stationName);
    void doNotObserveWeatherStation(String login, String stationName);
}
