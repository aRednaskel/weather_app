package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class WindDirectionProperty implements WeatherProperty {


    @Override
    public String getPropertyName() {
        return "windDirection";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getWindDirection();
    }
}
