package com.weather.imgw.weatherApp.api.user.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Optional;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
public class AirQualityIndexDto {

    private long id;
    private String stCalcDate;
    private Optional<IndexLevelDto> stIndexLevel;
    private Optional<IndexLevelDto> so2IndexLevel;
    private Optional<IndexLevelDto> no2IndexLevel;
    private Optional<IndexLevelDto> coIndexLevel;
    private Optional<IndexLevelDto> pm10IndexLevel;
    private Optional<IndexLevelDto> pm25IndexLevel;
    private Optional<IndexLevelDto> o3IndexLevel;
    private Optional<IndexLevelDto> c6h6IndexLevel;


}
