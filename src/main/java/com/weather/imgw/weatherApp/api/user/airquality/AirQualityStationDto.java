package com.weather.imgw.weatherApp.api.user.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Optional;


@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirQualityStationDto {

    private long id;
    @Setter
    private String stationName;
    private String stCalcDate;
    private IndexLevelDto stLevel;
    private IndexLevelDto so2Level;
    private IndexLevelDto no2Level;
    private IndexLevelDto coLevel;
    private IndexLevelDto pm10Level;
    private IndexLevelDto pm25Level;
    private IndexLevelDto o3Level;
    private IndexLevelDto c6h6Level;
    private Optional<IndexLevelDto> stIndexLevel;
    private Optional<IndexLevelDto> so2IndexLevel;
    private Optional<IndexLevelDto> no2IndexLevel;
    private Optional<IndexLevelDto> coIndexLevel;
    private Optional<IndexLevelDto> pm10IndexLevel;
    private Optional<IndexLevelDto> pm25IndexLevel;
    private Optional<IndexLevelDto> o3IndexLevel;
    private Optional<IndexLevelDto> c6h6IndexLevel;
}
