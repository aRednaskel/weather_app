package com.weather.imgw.weatherApp.api.user.weather;

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

    @GetMapping(path = "/notrainy")
    public ResponseEntity<List<String>> findNotRainyCities() {
        return ResponseEntity.ok(weatherStationFacade.findNotRainyCities());
    }

    @GetMapping(path = "/warmerthan/{temperature}")
    public ResponseEntity<List<String[]>> findCitiesWithTemperatureHigherThan(@PathVariable double temperature) {
        return ResponseEntity.ok(weatherStationFacade.findCitiesWithTemperatureHigherThan(temperature));
    }

    @GetMapping("/allCities")
    public ResponseEntity<List<WeatherStationDto>> findDataFromAllCities() {
        return ResponseEntity.ok(weatherStationFacade.showDataFromAllCities());
    }



}
