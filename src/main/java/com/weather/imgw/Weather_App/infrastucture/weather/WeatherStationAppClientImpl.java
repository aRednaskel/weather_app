package com.weather.imgw.Weather_App.infrastucture.weather;

import com.weather.imgw.Weather_App.api.weather.WeatherStationDto;
import com.weather.imgw.Weather_App.domain.weather.WeatherStationAppClient;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
class WeatherStationAppClientImpl implements WeatherStationAppClient {

    private final String weatherAppHost;
    private final String stationRetrieval;
    private  final RestTemplate restTemplate;

    public WeatherStationAppClientImpl(@Value("${weather.app.host}") String addressesUrl, @Value("${station.retrieval.uri}") String retrievePurchases, RestTemplate restTemplate) {
        this.weatherAppHost = addressesUrl;
        this.stationRetrieval = retrievePurchases;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<WeatherStationDto> downloadStations() {
        String url = String.join("", weatherAppHost, stationRetrieval);
        ResponseEntity<List<WeatherStationDto>> getData = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<WeatherStationDto>>(){});
        return getData.getBody();
    }
}
