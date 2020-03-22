package com.weather.imgw.weatherApp.api.weather;

import com.weather.imgw.weatherApp.domain.weather.WeatherStationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/weatherstation")
public class WeatherStationController {

    private final WeatherStationFacade weatherStationFacade;

    @PostMapping(path = "/newStation")
    public void createNewWeatherStation(@RequestBody WeatherStationDto weatherStationDto) {
        weatherStationFacade.createNewWeatherStation(weatherStationDto);
    }

    @GetMapping(path = "/notrainy")
    public ResponseEntity<List<String>> findNotRainyCities() {
        return ResponseEntity.ok(weatherStationFacade.findNotRainyCities());
    }

    @GetMapping(path = "/warmerthan/{temperature}")
    public ResponseEntity<List<String[]>> findCitiesWithTemperatureHigherThan(@PathVariable double temperature) {
        return ResponseEntity.ok(weatherStationFacade.findCitiesWithTemperatureHigherThan(temperature));
    }

}
