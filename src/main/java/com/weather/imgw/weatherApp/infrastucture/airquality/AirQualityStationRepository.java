package com.weather.imgw.weatherApp.infrastucture.airquality;

import com.weather.imgw.weatherApp.domain.model.airquality.AirQualityStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface AirQualityStationRepository extends JpaRepository<AirQualityStation, Long> {

    List<AirQualityStation> findByStationNameContaining(String cityName);
}
