package com.weather.imgw.weatherApp.domain.weatherproperties;

public interface WeatherAverageValuesRetrieval {

    double getAverageTemperature();
    double getAverageHumidity();
    double getAveragePrecipitation();
    double getAveragePressure();

}