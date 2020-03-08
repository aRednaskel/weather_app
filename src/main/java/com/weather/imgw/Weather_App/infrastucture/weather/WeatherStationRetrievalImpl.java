package com.weather.imgw.Weather_App.infrastucture.weather;

import com.weather.imgw.Weather_App.domain.weather.WeatherStationRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class WeatherStationRetrievalImpl implements WeatherStationRetrieval {

    private final WeatherRepository weatherRepository;

    @Override
    public List<String> findNotRainyCities() {
        List<String> cities = new ArrayList<>();
        weatherRepository.findBySumaOpaduLessThan(.1)
                .forEach(weatherStation -> cities.add(weatherStation.getStacja()));
        return cities;
    }

    @Override
    public List<String[]> findCitiesWithTemperature(double temperature) {
        List<String[]> cities = new ArrayList<>();
        weatherRepository.findByTemperaturaGreaterThan(temperature)
                .forEach(weatherStation -> cities.add(new String[]{weatherStation.getStacja(), String.valueOf(weatherStation.getTemperatura())}));
        return cities;
    }
}
