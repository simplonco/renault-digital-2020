package com.renault;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class Controller extends HttpServlet {

    @GetMapping("/persons")
    public List<PersonDto> get() {
        return List.of(
                new PersonDto("Emmanuel", "Macron", "Paris"),
                new PersonDto("François", "Hollande", "Versailles"),
                new PersonDto("Nicolas", "Sarkozy", "Toulouses"),
                new PersonDto("Jacques", "Chirac", "Marseille"),
                new PersonDto("François", "Mitterrand", "Nantes")
        );
    }

}
