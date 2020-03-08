package com.weather.imgw.Weather_App.domain.weather;

import com.weather.imgw.Weather_App.api.weather.WeatherStationDto;

import java.util.List;

public interface WeatherStationAppClient {

    List<WeatherStationDto> downloadStations();
}
