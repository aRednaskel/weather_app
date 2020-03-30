package com.weather.imgw.weatherApp.api.user.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Getter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AirQualityStationDto {

    private long id;
    private String stationName;
}
