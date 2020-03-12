package com.weather.imgw.Weather_App.domain.weatherproperties;

public interface WeatherAverageValuesRetrieval {

    double getAverageTemperature();
    double getAverageHumidity();
    double getAveragePrecipitation();
    double getAveragePressure();

}