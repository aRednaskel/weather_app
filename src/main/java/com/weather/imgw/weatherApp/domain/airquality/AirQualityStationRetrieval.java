package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.domain.model.airquality.AirQualityStation;

import java.util.List;

public interface AirQualityStationRetrieval {

    List<AirQualityStationDto> findAllStations();

    AirQualityStation findByid(long id);

    List<AirQualityStationDto> findStationsFromCity(String cityName);
}
