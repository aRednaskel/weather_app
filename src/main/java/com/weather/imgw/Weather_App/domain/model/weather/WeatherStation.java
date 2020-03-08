package com.weather.imgw.Weather_App.domain.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherStation {

    @Id
    private long id_stacji;
    private String stacja;
    private LocalDate data_pomiaru;
    private double temperatura;
    private double predkosc_wiatru;
    private double kierunek_wiatru;
    private double wilgotnosc_wzgledna;
    private double suma_opadu;
    private double cisnienie;


}
