package com.weather.imgw.Weather_App.domain.weather;

import com.weather.imgw.Weather_App.api.weather.WeatherStationDto;

import java.util.List;

public interface WeatherStationRetrieval {

    List<String> findNotRainyCities();

    List<String[]> findCitiesWithTemperature(double temperature);

    List<WeatherStationDto> findAllCities();
}
