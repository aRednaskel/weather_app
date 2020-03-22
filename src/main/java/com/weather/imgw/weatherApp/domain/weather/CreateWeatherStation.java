package com.weather.imgw.weatherApp.domain.weather;

import com.weather.imgw.weatherApp.api.weather.WeatherStationDto;

import java.util.List;

public interface CreateWeatherStation {
    void create(WeatherStationDto weatherStationDto);

    void create (List<WeatherStationDto> weatherStationDtos);
}
