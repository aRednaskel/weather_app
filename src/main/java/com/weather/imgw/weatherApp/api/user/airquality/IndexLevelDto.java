package com.weather.imgw.weatherApp.api.user.airquality;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class IndexLevelDto {

    private Long id;
    private String indexLevelName;
}
