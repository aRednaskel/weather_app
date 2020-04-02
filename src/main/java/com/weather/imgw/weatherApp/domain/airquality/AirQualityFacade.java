package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.infrastucture.data.AirQualityStationAppClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirQualityFacade {

    private final AirQualityStationCreator airQualityStationCreator;
    private final AirQualityStationRetrieval airQualityStationRetrieval;
    private final AirQualityStationAppClient airQualityStationAppClient;


    public void downloadAirQualityStations() {
        List<AirQualityStationDto> weatherStationDto = airQualityStationAppClient.downloadStations();
        airQualityStationCreator.create(weatherStationDto);
    }

    public List<AirQualityStationDto> findAllStation() {
        return airQualityStationRetrieval.findAllStations();
    }

    public List<AirQualityStationDto> findCityStations(String cityName) {
        return airQualityStationRetrieval.findStationsFromCity(cityName);
    }
}
