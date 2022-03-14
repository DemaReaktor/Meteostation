package com.example.Meteostation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {
    @GetMapping("/table")
    public String table(Model model){
        return "TableTemplate";
    }
}
