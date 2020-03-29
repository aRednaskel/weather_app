package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public interface WeatherProperty {
    String getPropertyName();
    double getProperty(WeatherStation weatherStation);

}
