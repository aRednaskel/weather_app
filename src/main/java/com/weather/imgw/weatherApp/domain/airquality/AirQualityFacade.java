package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;
import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.infrastucture.data.AirQualityStationAppClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirQualityFacade {

    private final AirQualityStationCreator airQualityStationCreator;
    private final AirQualityStationRetrieval airQualityStationRetrieval;
    private final AirQualityStationAppClient airQualityStationAppClient;
    private final AirQualityUpdater airQualityUpdater;

    public void downloadAirQualityStations() {
        List<AirQualityStationDto> weatherStationDto = airQualityStationAppClient.downloadStations();
        airQualityStationCreator.create(weatherStationDto);
    }

    public void updateAirQualityIndexes() {
        List<Long> stationsIds = new LinkedList<>();
        airQualityStationRetrieval.findAllStations()
                .forEach(station -> stationsIds.add(station.getId()));
        List<AirQualityIndexDto> airQualityIndexes = airQualityStationAppClient.downloadAirQualityIndexes(stationsIds);
        airQualityUpdater.updateAirQualityParams(airQualityIndexes);
    }

    public List<AirQualityStationDto> findAllStation() {
        return airQualityStationRetrieval.findAllStations();
    }

    public List<AirQualityStationDto> findCityStations(String cityName) {
        return airQualityStationRetrieval.findStationsFromCity(cityName);
    }
}
