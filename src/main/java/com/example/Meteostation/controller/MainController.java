package com.example.Meteostation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String landingPage(Model model){
        return "landingPage";//"home";//null;
    }
}
