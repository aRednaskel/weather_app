package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class WindVelocityProperty implements WeatherProperty {

    @Override
    public String getPropertyName() {
        return "windVelocity";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getWindVelocity();
    }
}
