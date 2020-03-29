package com.weather.imgw.weatherApp.infrastucture.user;

import com.weather.imgw.weatherApp.api.user.user.UserDto;
import com.weather.imgw.weatherApp.domain.model.user.User;
import com.weather.imgw.weatherApp.domain.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserCreatorImpl implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public void create(UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getEmail());
        userRepository.save(user);
    }
}
