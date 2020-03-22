package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface WeatherRepository extends JpaRepository<WeatherStation, Long> {

    List<WeatherStation> findBySumaOpaduLessThan(double notRainy);

    List<WeatherStation> findByTemperaturaGreaterThan(double temperature);
}
