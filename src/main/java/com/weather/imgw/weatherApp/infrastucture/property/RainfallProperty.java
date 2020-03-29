package com.weather.imgw.weatherApp.infrastucture.property;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

public class RainfallProperty implements WeatherProperty {

    @Override
    public String getPropertyName() {
        return "rainfall";
    }

    @Override
    public double getProperty(WeatherStation weatherStation) {
        return weatherStation.getRainfall();
    }
}
