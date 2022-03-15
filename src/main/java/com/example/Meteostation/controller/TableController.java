package com.example.Meteostation.controller;

import com.example.Meteostation.model.MeteoData;
import com.example.Meteostation.repository.MeteoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    private MeteoDataRepository meteoDataRepository;

    @GetMapping("/table")
    public String table(Model model){
        List<MeteoData> list = meteoDataRepository.findAll();
        model.addAttribute("title", "Table");
        model.addAttribute("data", list);
        return "Table";
    }
}
