package com.weather.imgw.weatherApp.infrastucture.user;

import com.weather.imgw.weatherApp.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
