package com.weather.imgw.weatherApp.api.user.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AirQualityStationDto {

    private long id;
    private String stationName;
    private String stCalcDate;
    private IndexLevelDto stIndexLevel;
    private IndexLevelDto so2IndexLevel;
    private IndexLevelDto no2IndexLevel;
    private IndexLevelDto coIndexLevel;
    private IndexLevelDto pm10IndexLevel;
    private IndexLevelDto pm25IndexLevel;
    private IndexLevelDto o3IndexLevel;
    private IndexLevelDto c6h6IndexLevel;
}
