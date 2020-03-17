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
                new PersonDto("Emmanuel", "Macron", "Paris"),
                new PersonDto("François", "Hollande", "Marseilles"),
                new PersonDto("Nicolas", "Sarkozy", "Lille"),
                new PersonDto("Jacques", "Chirac", "Nantes"),
                new PersonDto("François", "Mitterrand", "Brive")
        );
    }

    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable("city") String city) {
        int id = weatherService.getWhereInTheWorldId(city);
        return weatherService.getLocationWeather(id);
    }

}
