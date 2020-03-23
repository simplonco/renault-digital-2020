package com.renault.controllers;

import com.renault.entities.Language;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/language")
public class LanguageController extends HttpServlet {

    @GetMapping
    public List<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        for (Language language : Language.values()) {
            languages.add(language.getName());
        }
        return languages;
    }

}
