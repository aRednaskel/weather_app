package com.weather.imgw.weatherApp.domain.model.weather;

import com.weather.imgw.weatherApp.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class WeatherStation {

    @Id
    private long stationId;
    private String station;
    private LocalDate measurementDate;
    private int measurementTime;
    private double temperature;
    private double windVelocity;
    private int windDirection;
    private double humidity;
    private double rainfall;
    private double pressure;

    @ManyToMany
    private Set<User> users;


}
