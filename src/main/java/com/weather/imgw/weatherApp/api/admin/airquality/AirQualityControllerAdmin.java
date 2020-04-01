package com.weather.imgw.weatherApp.api.admin.airquality;

import com.weather.imgw.weatherApp.domain.airquality.AirQualityFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/airqualityadmin")
public class AirQualityControllerAdmin {

    private final AirQualityFacade airQualityFacade;

    @GetMapping
    public void getAirQualityStations() {
        airQualityFacade.downloadAirQualityStations();
    }

}
