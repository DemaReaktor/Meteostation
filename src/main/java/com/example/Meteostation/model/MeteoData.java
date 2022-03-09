package com.example.Meteostation.model;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table(name="MeteoData")
public class MeteoData {
    @Id
    @NotNull
    private int id;

    @NotNull
    private Timestamp date_time;

    //@NotNull
    private int tmprtr;

    @Size(max = 10)
    private String direction;

    //@NotNull
    @Min(0)
    private int average_speed;

    @Size(max = 41)
    private String weather_code;

    //@NotNull
    @Min(0)
    @Max(10)
    private int clouds = 0;

    @Min(0)
    private double vision_range;

    @Min(0)
    @Max(10)
    private int humidity = 0;

    private int atmo_pressure;

    @Min(0)
    private int min_cloud;

    public void setAverage_speed(int average_speed) {
        if (average_speed < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        this.average_speed = average_speed;
    }

    public void setClouds(int clouds) {
        if (clouds < 0 || clouds > 10) {
            throw new IllegalArgumentException("Not in range 0-10");
        }
        this.clouds = clouds;
    }

    public void setVision_range(double vision_range) {
        if (vision_range < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        this.vision_range = vision_range;
    }

    public void setHumidity(int humidity) {
        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Not in range 0-100");
        }
        this.humidity = humidity;
    }

    public void setMin_cloud(int min_cloud) {
        if (min_cloud < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        this.min_cloud = min_cloud;
    }
}
