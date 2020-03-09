package com.renault;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller {

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

}
