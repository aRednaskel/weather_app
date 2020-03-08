package com.weather.imgw.Weather_App.api.weather;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WeatherStationDto {
    private long id_stacji;
    private String stacja;
    private LocalDate data_pomiaru;
    private int godzina_pomiaru;
    private double temperatura;
    private double predkosc_wiatru;
    private int kierunek_wiatru;
    private double wilgotnosc_wzgledna;
    private double suma_opadu;
    private double cisnienie;


}
