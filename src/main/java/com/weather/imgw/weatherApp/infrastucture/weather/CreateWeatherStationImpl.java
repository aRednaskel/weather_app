package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.api.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;
import com.weather.imgw.weatherApp.domain.weather.CreateWeatherStation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
class CreateWeatherStationImpl implements CreateWeatherStation {

    private final WeatherRepository weatherRepository;

    @Override
    @Transactional
    public void create(WeatherStationDto weatherStationDto) {
        weatherRepository.save(
                WeatherStation.builder()
                        .id_stacji(weatherStationDto.getId_stacji())
                        .stacja(weatherStationDto.getStacja())
                        .data_pomiaru(weatherStationDto.getData_pomiaru())
                        .godzina_pomiaru(weatherStationDto.getGodzina_pomiaru())
                        .temperatura(weatherStationDto.getTemperatura())
                        .predkosc_wiatru(weatherStationDto.getPredkosc_wiatru())
                        .kierunek_wiatru(weatherStationDto.getKierunek_wiatru())
                        .wilgotnosc_wzgledna(weatherStationDto.getWilgotnosc_wzgledna())
                        .sumaOpadu(weatherStationDto.getSuma_opadu())
                        .cisnienie(weatherStationDto.getCisnienie())
                        .build()
        );
    }

    @Override
    public void create(List<WeatherStationDto> weatherStationDtos) {
        weatherStationDtos.forEach(this::create);
    }
}
