package com.weather.imgw.weatherApp.domain.model.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.IndexLevelDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AirQualityStations")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AirQualityStation {

    @Id
    private long id;
    private String stationName;
    private String measurementDate;
    private long stIndexLevelId;
    private String stIndexLevelName;
    private long so2IndexLevelId;
    private String so2IndexLevelName;
    private long no2IndexLevelId;
    private String no2IndexLevelName;
    private long coIndexLevelId;
    private String coIndexLevelName;
    private long pm10IndexLevelId;
    private String pm10IndexLevelName;
    private long pm25IndexLevelId;
    private String pm25IndexLevelName;
    private long o3IndexLevelId;
    private String o3IndexLevelName;
    private long c6h6IndexLevelId;
    private String c6h6IndexLevelName;

    public AirQualityStation(long id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }


    public void updateAirQualityIndexes(String measurementDate,
                             IndexLevelDto stIndexLevel,
                             IndexLevelDto so2IndexLevel,
                             IndexLevelDto no2IndexLevel,
                             IndexLevelDto coIndexLevel,
                             IndexLevelDto pm10IndexLevel,
                             IndexLevelDto pm25IndexLevel,
                             IndexLevelDto o3IndexLevel,
                             IndexLevelDto c6h6IndexLevel) {

        this.measurementDate = measurementDate;
        this.stIndexLevelId = stIndexLevel.getId();
        this.stIndexLevelName = stIndexLevel.getIndexLevelName();

        this.so2IndexLevelId = so2IndexLevel.getId();
        this.so2IndexLevelName = so2IndexLevel.getIndexLevelName();

        this.no2IndexLevelId = no2IndexLevel.getId();
        this.no2IndexLevelName = no2IndexLevel.getIndexLevelName();

        this.coIndexLevelId = coIndexLevel.getId();
        this.coIndexLevelName = coIndexLevel.getIndexLevelName();

        this.pm10IndexLevelId = pm10IndexLevel.getId();
        this.pm10IndexLevelName = pm10IndexLevel.getIndexLevelName();

        this.pm25IndexLevelId = pm25IndexLevel.getId();
        this.pm25IndexLevelName = pm25IndexLevel.getIndexLevelName();

        this.o3IndexLevelId = o3IndexLevel.getId();
        this.o3IndexLevelName = o3IndexLevel.getIndexLevelName();

        this.c6h6IndexLevelId = c6h6IndexLevel.getId();
        this.c6h6IndexLevelName = c6h6IndexLevel.getIndexLevelName();
    }

}
