package com.weather.imgw.weatherApp.api.user.weatherproperties;

import com.weather.imgw.weatherApp.domain.weather.WeatherStationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/averageweathervalues")
public class WeatherValuesController {

    private final WeatherStationFacade weatherStationFacade;

    @GetMapping
    public ResponseEntity<String> averageValues() {
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        StringBuilder averageValues = new StringBuilder();
        averageValues.append("Average temperature : ")
                .append(decimalFormat.format(weatherStationFacade.getAverageTemperature()))
                .append("\nAverage humidity : ")
                .append(decimalFormat.format(weatherStationFacade.getAverageHumidity()))
                .append("\nAverage precipitation : ")
                .append(decimalFormat.format(weatherStationFacade.getAveragePrecipitation()))
                .append("\nAverage pressure : ")
                .append(decimalFormat.format(weatherStationFacade.getAveragePressure() + 100));
        return ResponseEntity.ok(averageValues.toString());
    }

    @GetMapping(path = "/averagetemperature")
    public ResponseEntity<Double> averageTemperature() {
        return ResponseEntity.ok(weatherStationFacade.getAverageTemperature());
    }

    @GetMapping(path = "/averagehumidity")
    public ResponseEntity<Double> averageHumidity() {
        return ResponseEntity.ok(weatherStationFacade.getAverageHumidity());
    }

    @GetMapping(path = "/averagePrecipitation")
    public ResponseEntity<Double> averagePrecipitation() {
        return ResponseEntity.ok(weatherStationFacade.getAveragePrecipitation());
    }

    @GetMapping(path = "/averagepressure")
    public ResponseEntity<Double> averageRressure() {
        return ResponseEntity.ok(weatherStationFacade.getAveragePressure());
    }


}
