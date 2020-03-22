package com.weather.imgw.weatherApp.domain.weather;

import com.weather.imgw.weatherApp.api.weather.WeatherStationDto;

import java.util.List;

public interface WeatherStationRetrieval {

    List<String> findNotRainyCities();

    List<String[]> findCitiesWithTemperature(double temperature);

    List<WeatherStationDto> findAllCities();
}
