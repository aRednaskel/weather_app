package com.weather.imgw.weatherApp.api.user.airquality;

import com.weather.imgw.weatherApp.domain.airquality.AirQualityFacade;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/airquality")
@Validated
@Api(description = "Data retrieved from https://powietrze.gios.gov.pl/pjp/content/api")
public class AirQualityController {

    private final AirQualityFacade airQualityFacade;

    @GetMapping("/allStations")
    public ResponseEntity<List<AirQualityStationDto>> findAllStation() {
        return ResponseEntity.ok(airQualityFacade.findAllStation());
    }

    @GetMapping
    public ResponseEntity<List<AirQualityStationDto>> findStationsFromCity(@RequestParam @Size(min = 3, max = 20)  String cityName) {
        return ResponseEntity.ok(airQualityFacade.findCityStations(cityName));
    }
}
