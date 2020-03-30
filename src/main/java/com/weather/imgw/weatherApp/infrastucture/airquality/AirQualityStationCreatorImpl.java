package com.weather.imgw.weatherApp.infrastucture.airquality;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.domain.airquality.AirQualityStationCreator;
import com.weather.imgw.weatherApp.domain.model.airquality.AirQualityStation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirQualityStationCreatorImpl implements AirQualityStationCreator {

    private final AirQualityStationRepository airQualityStationRepository;

    @Override
    @Transactional
    public void create(AirQualityStationDto airQualityStationDto) {
        airQualityStationRepository.save(new AirQualityStation(airQualityStationDto.getId(), airQualityStationDto.getStationName()));
    }

    @Override
    public void create(List<AirQualityStationDto> airQualityStationDto) {
        airQualityStationDto.forEach(this::create);
    }
}
