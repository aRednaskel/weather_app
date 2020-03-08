package com.weather.imgw.Weather_App.domain.weather;

import java.util.List;

public interface WeatherStationRetrieval {

    List<String> findNotRainyCities();

    List<String[]> findCitiesWithTemperature(double temperature);
}
