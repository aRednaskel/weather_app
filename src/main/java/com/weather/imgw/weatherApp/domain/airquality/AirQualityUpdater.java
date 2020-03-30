package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;

import java.util.List;

public interface AirQualityUpdater {

    void updateAirQualityParams(List<AirQualityIndexDto> airQualityIndexes);
}
