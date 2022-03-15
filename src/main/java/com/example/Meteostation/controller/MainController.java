package com.example.Meteostation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String landingPage(Model model){
        model.addAttribute("title", "Insight Weather");
        return "tables";//"home";//null;
    }
}
