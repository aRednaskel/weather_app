package com.weather.imgw.weatherApp.infrastucture.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;
import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.api.user.airquality.IndexLevelDto;
import com.weather.imgw.weatherApp.domain.airquality.AirQualityStationRetrieval;
import com.weather.imgw.weatherApp.domain.model.airquality.AirQualityStation;
import com.weather.imgw.weatherApp.infrastucture.DtoMapper;
import com.weather.imgw.weatherApp.infrastucture.data.AirQualityStationAppClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
class AirQualityStationRetrievalImpl implements AirQualityStationRetrieval {

    private final AirQualityStationRepository airQualityStationRepository;
    private final AirQualityStationAppClient airQualityStationAppClient;

    @Override
    public List<AirQualityStationDto> findAllStations() {
        return DtoMapper.mapAirQualityStationToDto(
                airQualityStationRepository.findAll());
    }

    @Override
    public AirQualityStation findByid(long id) {
        return airQualityStationRepository.findById(id)
                .orElseThrow(
                        () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<AirQualityStationDto> findStationsFromCity(String cityName) {
        List<AirQualityStationDto> stationsWithCityName = new LinkedList<>();
        List<AirQualityStation> cities = airQualityStationRepository.findByStationNameContaining(cityName);
        cities
                .forEach(station -> stationsWithCityName.add(
                        DtoMapper.mapAirQualityIndexToStationDto(
                                airQualityStationAppClient.downloadAirQualityIndexes(station.getId()),station.getStationName())));
        return stationsWithCityName;
    }
}
