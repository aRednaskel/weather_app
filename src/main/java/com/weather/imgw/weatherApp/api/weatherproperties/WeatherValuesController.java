package com.weather.imgw.weatherApp.api.weatherproperties;

import com.weather.imgw.weatherApp.domain.weatherproperties.WeatherAverageValuesRetrieval;
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

    private final WeatherAverageValuesRetrieval weatherAverageValuesRetrieval;

    @GetMapping
    public ResponseEntity<String> averageValues() {
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        StringBuilder averageValues = new StringBuilder();
        averageValues.append("Average temperature : ")
                .append(decimalFormat.format(weatherAverageValuesRetrieval.getAverageTemperature()))
                .append("\nAverage humidity : ")
                .append(decimalFormat.format(weatherAverageValuesRetrieval.getAverageHumidity()))
                .append("\nAverage precipitation : ")
                .append(decimalFormat.format(weatherAverageValuesRetrieval.getAveragePrecipitation()))
                .append("\nAverage pressure : ")
                .append(decimalFormat.format(weatherAverageValuesRetrieval.getAveragePressure() + 100));
        return ResponseEntity.ok(averageValues.toString());
    }

    @GetMapping(path = "/averagetemperature")
    public ResponseEntity<Double> averageTemperature() {
        return ResponseEntity.ok(weatherAverageValuesRetrieval.getAverageTemperature());
    }

    @GetMapping(path = "/averagehumidity")
    public ResponseEntity<Double> averageHumidity() {
        return ResponseEntity.ok(weatherAverageValuesRetrieval.getAverageHumidity());
    }

    @GetMapping(path = "/averagePrecipitation")
    public ResponseEntity<Double> averagePrecipitation() {
        return ResponseEntity.ok(weatherAverageValuesRetrieval.getAveragePrecipitation());
    }

    @GetMapping(path = "/averagepressure")
    public ResponseEntity<Double> averageRressure() {
        return ResponseEntity.ok(weatherAverageValuesRetrieval.getAveragePressure());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeatherValuesController{");
        sb.append("weatherAverageValuesRetrieval=").append(weatherAverageValuesRetrieval);
        sb.append('}');
        return sb.toString();
    }


}
