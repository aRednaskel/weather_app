package com.weather.imgw.weatherApp.domain.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class WeatherStation {

    @Id
    private long id_stacji;
    private String stacja;
    private LocalDate data_pomiaru;
    private int godzina_pomiaru;
    private double temperatura;
    private double predkosc_wiatru;
    private int kierunek_wiatru;
    private double wilgotnosc_wzgledna;
    private double sumaOpadu;
    private double cisnienie;


}
