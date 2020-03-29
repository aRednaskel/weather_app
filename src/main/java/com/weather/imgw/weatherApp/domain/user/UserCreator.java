package com.weather.imgw.weatherApp.domain.user;

import com.weather.imgw.weatherApp.api.user.user.UserDto;

public interface UserCreator {
    void create(UserDto userDto);
}
