package com.weather.imgw.weatherApp.infrastucture.property;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class BooleanProperties {
    private boolean temperature;
    private boolean windVelocity;
    private boolean windDirection;
    private boolean humidity;
    private boolean rainfall;
    private boolean pressure;

    public static BooleanProperties weatherStationProperties(boolean temperature,
                                                             boolean windVelocity, boolean windDirection,
                                                             boolean humidity,
                                                             boolean rainfall,
                                                             boolean pressure) {
        return BooleanProperties.builder()
                .temperature(temperature)
                .windVelocity(windVelocity)
                .windDirection(windDirection)
                .humidity(humidity)
                .rainfall(rainfall)
                .pressure(pressure).build();
    }

    public List<WeatherProperty> returnedProperties() {
        List<WeatherProperty> properties = new ArrayList<>();
        if (temperature) {
            properties.add(new TemperatureProperty());
        }
        if (windVelocity) {
            properties.add(new WindVelocityProperty());
        }
        if (windDirection) {
            properties.add(new WindDirectionProperty());
        }
        if (humidity) {
            properties.add(new HumidityProperty());
        }
        if (rainfall) {
            properties.add(new RainfallProperty());
        }
        if (pressure) {
            properties.add(new PressureProperty());
        }
        return properties;
    }

}
