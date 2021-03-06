package com.weather.imgw.weatherApp.domain.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;

import java.util.List;

public interface WeatherStationAppClient {

    List<WeatherStationDto> downloadStations();
}
