CREATE DATABASE IF NOT EXISTS Meteostation;
USE Meteostation;

CREATE TABLE IF NOT EXISTS MeteoData (
date_time DATETIME NOT NULL,
tmprtr INT NOT NULL,
direction VARCHAR(10),
average_speed INT NOT NULL,
weather_code VARCHAR(41),
clouds INT DEFAULT 0 NOT NULL CHECK(clouds >= 0 AND clouds <= 10),
vision_range DOUBLE NOT NULL,
humidity INT CHECK(humidity >= 0 AND humidity <= 100) DEFAULT 0,
atmo_pressure INT NOT NULL,
min_cloud INT NOT NULL
);
/*
SELECT * FROM MeteoData;

LOAD DATA LOCAL INFILE "C:\Users\1\Desktop\2012-1.csv" INTO TABLE Meteostation.MeteoData
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(day_num, times, temp, dir, speed, weather, cloud, vrange, hum, atmo, min)
SET
date_time = CAST(CONCAT(DATE_FORMAT(day_num, '2012-1-%d'), ' ', times) AS DATETIME);

SET GLOBAL local_infile=1;
*/