package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class TemperatureProperty implements WeatherProperty {

    @Override
    public String getPropertyName() {
        return "temperature";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getTemperature();
    }
}
