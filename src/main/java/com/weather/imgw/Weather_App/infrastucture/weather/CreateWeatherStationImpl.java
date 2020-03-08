package com.weather.imgw.Weather_App.infrastucture.weather;

import com.weather.imgw.Weather_App.api.weather.WeatherStationDto;
import com.weather.imgw.Weather_App.domain.model.weather.WeatherStation;
import com.weather.imgw.Weather_App.domain.weather.CreateWeatherStation;
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
                        .temperatura(weatherStationDto.getTemperatura())
                        .predkosc_wiatru(weatherStationDto.getPredkosc_wiatru())
                        .kierunek_wiatru(weatherStationDto.getKierunek_wiatru())
                        .wilgotnosc_wzgledna(weatherStationDto.getWilgotnosc_wzgledna())
                        .suma_opadu(weatherStationDto.getSuma_opadu())
                        .cisnienie(weatherStationDto.getCisnienie())
                        .build()
        );
    }

    @Override
    public void create(List<WeatherStationDto> weatherStationDtos) {
        weatherStationDtos.forEach(this::create);
    }
}
