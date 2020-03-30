package com.weather.imgw.weatherApp.infrastucture.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;
import com.weather.imgw.weatherApp.api.user.airquality.IndexLevelDto;
import com.weather.imgw.weatherApp.domain.airquality.AirQualityStationRetrieval;
import com.weather.imgw.weatherApp.domain.airquality.AirQualityUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
class AirQualityUpdaterImpl implements AirQualityUpdater {

    private final AirQualityStationRetrieval airQualityStationRetrieval;

    @Override
    @Transactional
    public void updateAirQualityParams(List<AirQualityIndexDto> airQualityIndexes) {
        airQualityIndexes.forEach(
                airQualityIndexDto -> airQualityStationRetrieval.findByid(airQualityIndexDto.getId())
                        .updateAirQualityIndexes(airQualityIndexDto.getStCalcDate(),
                                airQualityIndexDto.getStIndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getSo2IndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getNo2IndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getCoIndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getPm10IndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getPm25IndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getO3IndexLevel().orElse(new IndexLevelDto(0l, "Property not found")),
                                airQualityIndexDto.getC6h6IndexLevel().orElse(new IndexLevelDto(0l, "Property not found"))));
    }
}
