package com.weather.imgw.weatherApp.infrastucture;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.api.user.user.UserDto;
import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.model.airquality.AirQualityStation;
import com.weather.imgw.weatherApp.domain.model.user.User;
import com.weather.imgw.weatherApp.domain.model.weather.WeatherStation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public static List<WeatherStationDto> mapWeatherStationToDto(Collection<WeatherStation> stations) {
        List<WeatherStationDto> stationDtos = stations.stream()
                .map(
                        weatherStationDto -> WeatherStationDto.builder()
                                .id_stacji(weatherStationDto.getStationId())
                                .stacja(weatherStationDto.getStation())
                                .data_pomiaru(weatherStationDto.getMeasurementDate())
                                .godzina_pomiaru(weatherStationDto.getMeasurementTime())
                                .temperatura(weatherStationDto.getTemperature())
                                .predkosc_wiatru(weatherStationDto.getWindVelocity())
                                .kierunek_wiatru(weatherStationDto.getWindDirection())
                                .wilgotnosc_wzgledna(weatherStationDto.getHumidity())
                                .suma_opadu(weatherStationDto.getRainfall())
                                .cisnienie(weatherStationDto.getPressure())
                                .build())
                .collect(Collectors.toList());
        return stationDtos;
    }

    public static List<AirQualityStationDto> mapAirQualityStationToDto(Collection<AirQualityStation> stations) {
        List<AirQualityStationDto> stationDtos = stations.stream()
                .map(
                        station -> new AirQualityStationDto(station.getId(), station.getStationName()))
                .collect(Collectors.toList());
        return stationDtos;
    }

    public static UserDto mapUserToDto(User user) {
        return new UserDto(user.getLogin(), user.getPassword(), user.getPassword());
    }
}
