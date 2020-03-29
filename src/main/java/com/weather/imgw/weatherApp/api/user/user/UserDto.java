package com.weather.imgw.weatherApp.api.user.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String login;
    private String password;
    private String email;
}
