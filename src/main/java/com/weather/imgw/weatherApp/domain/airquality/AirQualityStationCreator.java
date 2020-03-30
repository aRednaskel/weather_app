package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;

import java.util.List;

public interface AirQualityStationCreator {
    void create(AirQualityStationDto airQualityStationDto);

    void create(List<AirQualityStationDto> airQualityStationDto);
}
