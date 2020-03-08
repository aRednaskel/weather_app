package com.weather.imgw.Weather_App.infrastucture.weather;

import com.weather.imgw.Weather_App.domain.model.weather.WeatherStation;
import org.springframework.data.jpa.repository.JpaRepository;

interface WeatherRepository extends JpaRepository<WeatherStation, Long> {
}
