package com.example.Meteostation.repository;

import com.example.Meteostation.model.MeteoData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeteoDataRepository extends CrudRepository<MeteoData, Integer> {
    List <MeteoData> findAll();

}
