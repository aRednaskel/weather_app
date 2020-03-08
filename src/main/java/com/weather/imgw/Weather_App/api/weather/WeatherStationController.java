package com.weather.imgw.Weather_App.api.weather;

import com.weather.imgw.Weather_App.domain.weather.WeatherStationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/weatherstation")
public class WeatherStationController {

    private final WeatherStationFacade weatherStationFacade;

    @PostMapping
    public void createMultipleWeatherStationsFromImgw() {
        weatherStationFacade.createMultipleWeatherStationsFromImgwSite();
    }
}
