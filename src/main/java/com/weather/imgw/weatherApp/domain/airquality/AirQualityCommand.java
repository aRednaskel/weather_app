package com.weather.imgw.weatherApp.domain.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.IndexLevelDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AirQualityCommand {

    private long id;
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
