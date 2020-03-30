package com.weather.imgw.weatherApp.infrastucture.data;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;
import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirQualityStationAppClient {

    private final String airQualityStations;
    private final String airQualityParams;
    private  final RestTemplate restTemplate;

    public AirQualityStationAppClient(@Value("${airqualitystations.app}") String airQualityStations, @Value("${airQualityParams.app}") String airQualityParams, RestTemplate restTemplate) {
        this.airQualityStations = airQualityStations;
        this.airQualityParams = airQualityParams;
        this.restTemplate = restTemplate;
    }

    public List<AirQualityStationDto> downloadStations() {
        ResponseEntity<List<AirQualityStationDto>> getData = restTemplate.exchange(
                airQualityStations,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<AirQualityStationDto>>(){});
        return getData.getBody();
    }

    public List<AirQualityIndexDto> downloadAirQualityIndexes(List<Long> stationIds) {
        List<AirQualityIndexDto> airQualityIndexDtos = new ArrayList<>();
        stationIds.forEach(
                station -> {
                    String url = String.join("", airQualityParams, String.valueOf(station));
                        ResponseEntity<AirQualityIndexDto> getData = restTemplate.exchange(
                                url,
                                HttpMethod.GET,
                                HttpEntity.EMPTY,
                                new ParameterizedTypeReference<AirQualityIndexDto>(){});
                        airQualityIndexDtos.add(getData.getBody());
                });

        return airQualityIndexDtos;
    }
}
