package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
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
                        .stationId(weatherStationDto.getId_stacji())
                        .station(weatherStationDto.getStacja())
                        .measurementDate(weatherStationDto.getData_pomiaru())
                        .measurementTime(weatherStationDto.getGodzina_pomiaru())
                        .temperature(weatherStationDto.getTemperatura())
                        .windVelocity(weatherStationDto.getPredkosc_wiatru())
                        .windDirection(weatherStationDto.getKierunek_wiatru())
                        .humidity(weatherStationDto.getWilgotnosc_wzgledna())
                        .rainfall(weatherStationDto.getSuma_opadu())
                        .pressure(weatherStationDto.getCisnienie())
                        .build()
        );
    }

    @Override
    public void create(List<WeatherStationDto> weatherStationDtos) {
        weatherStationDtos.forEach(this::create);
    }
}
