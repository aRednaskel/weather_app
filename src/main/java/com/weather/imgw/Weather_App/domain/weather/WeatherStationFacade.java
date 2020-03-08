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

    public void createMultipleWeatherStationsFromImgwSite() {
        List<WeatherStationDto> weatherStationDto = weatherStationAppClient.downloadStations();
        createWeatherStation.create(weatherStationDto);
    }

}
