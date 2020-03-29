package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import com.weather.imgw.weatherApp.domain.weather.WeatherStationRetrieval;
import com.weather.imgw.weatherApp.infrastucture.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class WeatherStationRetrievalImpl implements WeatherStationRetrieval {

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherStation findWithStationName(String name) {
        return weatherRepository.findByStation(name)
                .orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<String> findNotRainyCities() {
        List<String> cities = new ArrayList<>();
        weatherRepository.findByRainfallLessThan(.1)
                .forEach(weatherStation -> cities.add(weatherStation.getStation()));
        return cities;
    }

    @Override
    public List<String[]> findCitiesWithTemperature(double temperature) {
        List<String[]> cities = new ArrayList<>();
        weatherRepository.findByTemperatureGreaterThan(temperature)
                .forEach(weatherStation -> cities.add(new String[]{weatherStation.getStation(), String.valueOf(weatherStation.getTemperature())}));
        return cities;
    }

    @Override
    public List<WeatherStationDto> findAllCities() {
        return DtoMapper.mapWeatherStationToDto(weatherRepository.findAll());
    }

    @Override
    public double getAverageTemperature() {
        List<WeatherStation> allCities = weatherRepository.findAll();
        double averageTemperature = 0;
        for (WeatherStation city : allCities) {
            averageTemperature += city.getTemperature();
        }
        return averageTemperature / allCities.size();
    }

    @Override
    public double getAverageHumidity() {
        List<WeatherStation> allCities = weatherRepository.findAll();
        double averageHumidity = 0;
        for (WeatherStation city : allCities) {
            averageHumidity += city.getHumidity();
        }
        return averageHumidity / allCities.size();
    }

    @Override
    public double getAveragePrecipitation() {
        List<WeatherStation> allCities = weatherRepository.findAll();
        double averagePrecipitation = 0;
        for (WeatherStation city : allCities) {
            averagePrecipitation += city.getRainfall();
        }
        return averagePrecipitation / allCities.size();
    }

    @Override
    public double getAveragePressure() {
        List<WeatherStation> allCities = weatherRepository.findAll();
        double averagePressure = 0;
        for (WeatherStation city : allCities) {
            averagePressure += city.getPressure();
        }
        return averagePressure / allCities.size();
    }
}
