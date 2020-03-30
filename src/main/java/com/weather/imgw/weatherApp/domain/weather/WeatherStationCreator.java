package com.weather.imgw.weatherApp.domain.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;

import java.util.List;

public interface WeatherStationCreator {
    void create(WeatherStationDto weatherStationDto);

    void create (List<WeatherStationDto> weatherStationDtos);
}
