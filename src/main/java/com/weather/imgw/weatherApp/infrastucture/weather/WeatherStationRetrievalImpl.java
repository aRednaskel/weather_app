package com.weather.imgw.weatherApp.infrastucture.weather;

import com.weather.imgw.weatherApp.api.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.weather.WeatherStationRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class WeatherStationRetrievalImpl implements WeatherStationRetrieval {

    private final WeatherRepository weatherRepository;

    @Override
    public List<String> findNotRainyCities() {
        List<String> cities = new ArrayList<>();
        weatherRepository.findBySumaOpaduLessThan(.1)
                .forEach(weatherStation -> cities.add(weatherStation.getStacja()));
        return cities;
    }

    @Override
    public List<String[]> findCitiesWithTemperature(double temperature) {
        List<String[]> cities = new ArrayList<>();
        weatherRepository.findByTemperaturaGreaterThan(temperature)
                .forEach(weatherStation -> cities.add(new String[]{weatherStation.getStacja(), String.valueOf(weatherStation.getTemperatura())}));
        return cities;
    }

    @Override
    public List<WeatherStationDto> findAllCities() {
        List<WeatherStationDto> allCitiesDto = weatherRepository.findAll().stream().map(weatherStationDto -> WeatherStationDto.builder()
                .id_stacji(weatherStationDto.getId_stacji())
                .stacja(weatherStationDto.getStacja())
                .data_pomiaru(weatherStationDto.getData_pomiaru())
                .godzina_pomiaru(weatherStationDto.getGodzina_pomiaru())
                .temperatura(weatherStationDto.getTemperatura())
                .predkosc_wiatru(weatherStationDto.getPredkosc_wiatru())
                .kierunek_wiatru(weatherStationDto.getKierunek_wiatru())
                .wilgotnosc_wzgledna(weatherStationDto.getWilgotnosc_wzgledna())
                .suma_opadu(weatherStationDto.getSumaOpadu())
                .cisnienie(weatherStationDto.getCisnienie())
                .build()).collect(Collectors.toList());
        return allCitiesDto;
    }
}
