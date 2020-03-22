package com.weather.imgw.weatherApp.config;

import com.weather.imgw.weatherApp.domain.weather.WeatherStationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class Scheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final WeatherStationFacade weatherStationFacade;

    @Scheduled(fixedRate = 7200000)
    public void reportCurrentTime() {
        weatherStationFacade.createMultipleWeatherStationsFromImgwSite();
        log.info("Data was updated. The time is now {}", dateFormat.format(new Date()));
    }
}
