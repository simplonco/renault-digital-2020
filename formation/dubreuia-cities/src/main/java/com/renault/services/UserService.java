package com.renault.services;

import com.renault.entities.City;
import com.renault.entities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(int id);

    void save(User user);

    void followCityAndSave(User user, City city);

    void unfollowCityAndSave(User user, City city);

}
