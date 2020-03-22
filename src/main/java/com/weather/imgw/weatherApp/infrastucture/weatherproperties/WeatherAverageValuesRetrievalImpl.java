package com.weather.imgw.weatherApp.infrastucture.weatherproperties;

import com.weather.imgw.weatherApp.api.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.weather.WeatherStationRetrieval;
import com.weather.imgw.weatherApp.domain.weatherproperties.WeatherAverageValuesRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class WeatherAverageValuesRetrievalImpl implements WeatherAverageValuesRetrieval {

    private final WeatherStationRetrieval weatherStationRetrieval;

    @Override
    public double getAverageTemperature() {
        List<WeatherStationDto> allCities = weatherStationRetrieval.findAllCities();
        double averageTemperature = 0;
        for (WeatherStationDto city : allCities) {
            averageTemperature += city.getTemperatura();
        }
        return averageTemperature / allCities.size();
    }

    @Override
    public double getAverageHumidity() {
        List<WeatherStationDto> allCities = weatherStationRetrieval.findAllCities();
        double averageHumidity = 0;
        for (WeatherStationDto city : allCities) {
            averageHumidity += city.getWilgotnosc_wzgledna();
        }
        return averageHumidity / allCities.size();
    }

    @Override
    public double getAveragePrecipitation() {
        List<WeatherStationDto> allCities = weatherStationRetrieval.findAllCities();
        double averagePrecipitation = 0;
        for (WeatherStationDto city : allCities) {
            averagePrecipitation += city.getSuma_opadu();
        }
        return averagePrecipitation / allCities.size();
    }

    @Override
    public double getAveragePressure() {
        List<WeatherStationDto> allCities = weatherStationRetrieval.findAllCities();
        double averagePressure = 0;
        for (WeatherStationDto city : allCities) {
            averagePressure += city.getCisnienie();
        }
        return averagePressure / allCities.size();
    }
}
