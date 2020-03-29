package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class HumidityProperty implements WeatherProperty {

    @Override
    public String getPropertyName() {
        return "humidity";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getHumidity();
    }
}
