package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;

import java.util.List;

public interface AirQualityStationRetrieval {

    List<AirQualityStationDto> findAllStations();

    List<AirQualityStationDto> findStationsFromCity(String cityName);
}
