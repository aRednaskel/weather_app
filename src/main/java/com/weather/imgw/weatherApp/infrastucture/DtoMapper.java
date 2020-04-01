package com.weather.imgw.weatherApp.infrastucture;

import com.weather.imgw.weatherApp.api.user.airquality.AirQualityIndexDto;
import com.weather.imgw.weatherApp.api.user.airquality.AirQualityStationDto;
import com.weather.imgw.weatherApp.api.user.airquality.IndexLevelDto;
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
                        station -> AirQualityStationDto.builder()
                                .id(station.getId())
                                .stationName(station.getStationName()).build())
                .collect(Collectors.toList());
        return stationDtos;
    }

    public static AirQualityStationDto mapAirQualityIndexToStationDto(AirQualityIndexDto airQualityIndexes, String cityName) {
        AirQualityStationDto airQualityStationDto = AirQualityStationDto.builder()
                .id(airQualityIndexes.getId())
                .stationName(cityName)
                .stCalcDate(airQualityIndexes.getStCalcDate())
                .stIndexLevel(airQualityIndexes.getStIndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .so2IndexLevel(airQualityIndexes.getSo2IndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .no2IndexLevel(airQualityIndexes.getNo2IndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .coIndexLevel(airQualityIndexes.getCoIndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .pm10IndexLevel(airQualityIndexes.getPm10IndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .pm25IndexLevel(airQualityIndexes.getPm25IndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .o3IndexLevel(airQualityIndexes.getO3IndexLevel()
                        .orElse(new IndexLevelDto(0l, "Property not found")))
                .c6h6IndexLevel(airQualityIndexes.getC6h6IndexLevel()
                                .orElse(new IndexLevelDto(0l, "Property not found")))
                .build();
        return airQualityStationDto;
    }

    public static UserDto mapUserToDto(User user) {
        return new UserDto(user.getLogin(), user.getPassword(), user.getPassword());
    }
}
