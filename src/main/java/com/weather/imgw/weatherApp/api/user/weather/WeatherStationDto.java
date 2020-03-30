package com.weather.imgw.weatherApp.api.user.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
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
