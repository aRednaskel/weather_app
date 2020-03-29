package com.weather.imgw.weatherApp.domain.model.user;

import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String password;
    @Email
    private String email;

    @ManyToMany
    private Set<WeatherStation> observedStations;


    public User(String login, String password, @Email String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.observedStations = new HashSet<>();
    }

    public void addObservedWeatherStation(WeatherStation observedStation) {
        this.observedStations.add(observedStation);
    }

    public void deleteObservedWeatherStation(WeatherStation observedStation) {
        this.observedStations.remove(observedStation);
    }

}
