package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface WeatherRepository extends JpaRepository<WeatherStation, Long> {

    List<WeatherStation> findByRainfallLessThan(double notRainy);

    List<WeatherStation> findByTemperatureGreaterThan(double temperature);

    Optional<WeatherStation> findByStation(String name);
}
