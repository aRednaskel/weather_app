package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class PressureProperty implements WeatherProperty {

    @Override
    public String getPropertyName() {
        return "pressure";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getPressure();
    }
}
