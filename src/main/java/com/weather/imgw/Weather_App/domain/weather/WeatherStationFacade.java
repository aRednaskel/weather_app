package com.weather.imgw.Weather_App.domain.weather;

import com.weather.imgw.Weather_App.api.weather.WeatherStationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherStationFacade {

    private final CreateWeatherStation createWeatherStation;
    private final WeatherStationAppClient weatherStationAppClient;
    private final WeatherStationRetrieval weatherStationRetrieval;

    public void createNewWeatherStation(WeatherStationDto weatherStationDto) {
        createWeatherStation.create(weatherStationDto);
    }

    public void createMultipleWeatherStationsFromImgwSite() {
        List<WeatherStationDto> weatherStationDto = weatherStationAppClient.downloadStations();
        createWeatherStation.create(weatherStationDto);
    }

    public List<String> findNotRainyCities () {
        return weatherStationRetrieval.findNotRainyCities();
    }

    public List<String[]> findCitiesWithTemperatureHigherThan(double temperature) {
        return weatherStationRetrieval.findCitiesWithTemperature(temperature);
    }


}
