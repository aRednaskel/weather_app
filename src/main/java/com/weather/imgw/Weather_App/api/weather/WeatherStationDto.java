package com.weather.imgw.Weather_App.api.weather;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WeatherStationDto {
    private long id_stacji;
    private String stacja;
    private LocalDate data_pomiaru;
    private double godzina_pomiaru;
    private double temperatura;
    private double predkosc_wiatru;
    private double kierunek_wiatru;
    private double wilgotnosc_wzgledna;
    private double suma_opadu;
    private double cisnienie;

    //    {
//        id_stacji: "12295",
//                stacja: "Białystok",
//            data_pomiaru: "2020-03-08",
//            godzina_pomiaru: "9",
//            temperatura: "5.1",
//            predkosc_wiatru: "2",
//            kierunek_wiatru: "250",
//            wilgotnosc_wzgledna: "97.2",
//            suma_opadu: "0000000002.9",
//            cisnienie: "1017.6"
//    },
}
