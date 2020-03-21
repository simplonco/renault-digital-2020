package com.renault;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller extends HttpServlet {

    @GetMapping("/")
    public String getWeather() {
        return "{}";
    }

}
