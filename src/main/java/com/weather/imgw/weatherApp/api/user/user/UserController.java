package com.weather.imgw.weatherApp.api.user.user;

import com.weather.imgw.weatherApp.api.user.weather.WeatherStationDto;
import com.weather.imgw.weatherApp.domain.user.UserFacade;
import com.weather.imgw.weatherApp.infrastucture.property.BooleanProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/new")
    public void createUser(@RequestBody UserDto userDto) {
        userFacade.createUser(userDto);
    }

    @GetMapping("/{login}")
    public UserDto findUserByLogin(@PathVariable String login) {
        return userFacade.findUserByLogin(login);
    }

    @GetMapping("observedcities/{login}")
    public ResponseEntity<List<WeatherStationDto>> findDataFromAllCities(@PathVariable String login) {
        return ResponseEntity.ok(userFacade.showObservedStations(login));
    }

    @GetMapping("citieswithparameters")
    public ResponseEntity<Map<String, Map<String, Double>>> citiesWithParameters(@RequestParam String login,
                                                                                 @RequestParam(defaultValue = "true") boolean temperature,
                                                                                 @RequestParam(defaultValue = "true") boolean windVelocity, @RequestParam(defaultValue = "true") boolean windDirection,
                                                                                 @RequestParam(defaultValue = "true") boolean humidity,
                                                                                 @RequestParam(defaultValue = "true") boolean rainfall,
                                                                                 @RequestParam(defaultValue = "true") boolean pressure) {
        BooleanProperties weatherProperties = BooleanProperties.weatherStationProperties(temperature, windVelocity, windDirection, humidity, rainfall, pressure);
        return ResponseEntity.ok(
                userFacade.showObservedStationsWithParams(login, weatherProperties));
    }


    @PutMapping("/observestation")
    public void addObservedStation(@RequestParam String login,@RequestParam String stationame) {
        userFacade.addObservedStation(login, stationame);
    }

    @PutMapping("/donotobservestation")
    public void doNotObserveStation(@RequestParam String login,@RequestParam String stationame) {
        userFacade.doNotObserveStation(login, stationame);
    }

}
