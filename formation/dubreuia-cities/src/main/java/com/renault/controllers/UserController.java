package com.renault.controllers;

import com.renault.dtos.UserDto;
import com.renault.entities.City;
import com.renault.entities.User;
import com.renault.services.CityService;
import com.renault.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @PostMapping("/user")
    public void insertUser(@RequestBody @Valid UserDto userDto) {
        userService.save(new User(userDto.getName()));
    }

    @PostMapping("/user/{userId}/followCity/{cityId}")
    public void followCity(@PathVariable("userId") int userId, @PathVariable("cityId") int cityId) {
        User user = userService.findUser(userId).orElseThrow();
        City city = cityService.getCity(cityId).orElseThrow();
        userService.followCityAndSave(user, city);
    }

    @DeleteMapping("/user/{userId}/followCity/{cityId}")
    public void unfollowCity(@PathVariable("userId") int userId, @PathVariable("cityId") int cityId) {
        User user = userService.findUser(userId).orElseThrow();
        City city = cityService.getCity(cityId).orElseThrow();
        userService.unfollowCityAndSave(user, city);
    }

}
