package com.weather.imgw.weatherApp.domain.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

import java.util.List;

public interface WeatherStationRetrieval {

    List<String> findNotRainyCities();

    List<String[]> findCitiesWithTemperature(double temperature);

    List<WeatherStationDto> findAllCities();

    WeatherStation findWithStationName(String name);

    double getAverageTemperature();

    double getAverageHumidity();

    double getAveragePrecipitation();

    double getAveragePressure();
}
