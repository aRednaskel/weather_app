package com.weather.imgw.weatherApp.api.admin.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.weather.WeatherStationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/weatherstationadmin")
public class WeatherStationControllerAdmin {

    private final WeatherStationFacade weatherStationFacade;

    @PostMapping(path = "/newStation")
    public void createNewWeatherStation(@RequestBody WeatherStationDto weatherStationDto) {
        weatherStationFacade.createNewWeatherStation(weatherStationDto);
    }
}
