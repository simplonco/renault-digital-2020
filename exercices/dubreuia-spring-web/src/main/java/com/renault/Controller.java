package com.renault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller extends HttpServlet {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/persons")
    public List<PersonDto> get() {
        return List.of(
                new PersonDto("Emmanuel", "Macron"),
                new PersonDto("François", "Hollande"),
                new PersonDto("Nicolas", "Sarkozy"),
                new PersonDto("Jacques", "Chirac"),
                new PersonDto("François", "Mitterrand")
        );
    }

    @GetMapping("/weater/{city}")
    public String getWeather(@PathVariable("city") String city) {
        int id = weatherService.getWhereInTheWorldId(city);
        return weatherService.getLocationWeather(id);
    }

}
