import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MeteoData {
private Integer month;
private Integer day;
private Integer hour;
private Integer minute;
private Integer temperature;
private Wind wind;
private Integer windSpeed;
private List<WhetherCode> whetherCode;
private Integer numberOfClouds;
private Double rangeOfVision;
private Integer relativeHumidity;
private Integer atmosphericPressure;
private Integer lowerLimitOfClouds;

public MeteoData(){
    this.month = null;
    this.day = null;
    this.hour = null;
    this.minute = null;
    this.temperature = null;
    this.windSpeed = null;
    this.wind =null;
    this.whetherCode = null;
    this.numberOfClouds = null;
    this.rangeOfVision = null;
    this.relativeHumidity = null;
    this.atmosphericPressure = null;
    this.lowerLimitOfClouds = null;
}
public MeteoData(Integer month,Integer day,Integer hour,Integer minute,Integer temperature,Wind wind,
                 Integer windSpeed, List<WhetherCode> whetherCode, Integer numberOfClouds,Double rangeOfVision,
                 Integer relativeHumidity,Integer atmosphericPressure, Integer lowerLimitOfClouds){
//if(month<1||month>12||day<1||day>31||hour<0||hour>24||minute<0||minute>60||windSpeed<0||numberOfClouds<0||
//numberOfClouds>10||relativeHumidity<0||relativeHumidity>100||lowerLimitOfClouds<0)
//    throw new Exception("incorrect input data");
this.month = month;
this.day = day;
this.hour = hour;
this.minute = minute;
this.temperature = temperature;
this.windSpeed = windSpeed;
if (windSpeed!=0)
    this.wind = wind;
else
    this.wind =Wind.None;
this.whetherCode = whetherCode;
this.numberOfClouds = numberOfClouds;
this.rangeOfVision = rangeOfVision;
this.relativeHumidity = relativeHumidity;
this.atmosphericPressure = atmosphericPressure;
this.lowerLimitOfClouds = lowerLimitOfClouds;
}

    public Integer getMonth() {
        return month;
    }
    public Integer getDay() {
        return day;
    }
    public Integer getHour() {
        return hour;
    }
    public Integer getMinute() {
        return minute;
    }
    public Integer getTemperature() {
        return temperature;
    }
    public Wind getWind() {
        return wind;
    }
    public Integer getWindSpeed() {
        return windSpeed;
    }
    public List<WhetherCode> getWhetherCode() {
        return whetherCode;
    }
    public Integer getNumberOfClouds() {
        return numberOfClouds;
    }
    public Double getRangeOfVision() {
        return rangeOfVision;
    }
    public Integer getRelativeHumidity() {
        return relativeHumidity;
    }
    public Integer getAtmosphericPressure() {
        return atmosphericPressure;
    }
    public Integer getLowerLimitOfClouds() {
        return lowerLimitOfClouds;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
    public void setDay(Integer day) {
        this.day = day;
    }
    public void setHour(Integer hour) {
        this.hour = hour;
    }
    public void setMinute(Integer minute) {
        this.minute = minute;
    }
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public void setWind(String wind){
    switch (wind){
        case "East":
            this.wind = Wind.East;
            break;
        case "West":
            this.wind = Wind.West;
            break;
        case "North":
            this.wind = Wind.North;
            break;
        case "South":
            this.wind = Wind.South;
            break;
        default:this.wind = null;
        break;
    }
    }
    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }
    public void setWhetherCode(List<WhetherCode> whetherCode) {
        this.whetherCode = whetherCode;
    }
    public void setWhetherCode(String whetherCode){
    List<String> codes= Arrays.stream(whetherCode.split("\\+")).toList();
    this.whetherCode=new LinkedList<>();
    for (String element:codes)
    switch (element) {
        case "CL":
            this.whetherCode.add(WhetherCode.CL);
            break;
        case "BR":
            this.whetherCode.add(WhetherCode.BR);
            break;
        case "DZ":
            this.whetherCode.add(WhetherCode.DZ);
            break;
        case "FG":
            this.whetherCode.add(WhetherCode.FG);
            break;
        case "HL":
            this.whetherCode.add(WhetherCode.HL);
            break;
        case "HZ":
            this.whetherCode.add(WhetherCode.HZ);
            break;
        case "RA":
            this.whetherCode.add(WhetherCode.RA);
            break;
        case "SHRA":
            this.whetherCode.add(WhetherCode.SHRA);
            break;
        case "SHSN":
            this.whetherCode.add(WhetherCode.SHSN);
            break;
        case "TS":
            this.whetherCode.add(WhetherCode.TS);
            break;
        case "SN":
            this.whetherCode.add(WhetherCode.SN);
            break;
        default:
            this.whetherCode.add(null);
            break;
    }
    }
    public void setNumberOfClouds(Integer numberOfClouds) {
        this.numberOfClouds = numberOfClouds;
    }
    public void setRangeOfVision(Double rangeOfVision) {
        this.rangeOfVision = rangeOfVision;
    }
    public void setRelativeHumidity(Integer relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }
    public void setAtmosphericPressure(Integer atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }
    public void setLowerLimitOfClouds(Integer lowerLimitOfClouds) {
        this.lowerLimitOfClouds = lowerLimitOfClouds;
    }

    @Override
    public String toString() {
        return "MeteoData{" +
                "month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", windSpeed=" + windSpeed +
                ", whetherCode=" + whetherCode +
                ", numberOfClouds=" + numberOfClouds +
                ", rangeOfVision=" + rangeOfVision +
                ", relativeHumidity=" + relativeHumidity +
                ", atmosphericPressure=" + atmosphericPressure +
                ", lowerLimitOfClouds=" + lowerLimitOfClouds +
                '}';
    }
}
enum Wind{
    North,
    South,
    East,
    West,
    N_W,
    N_E,
    S_W,
    S_E,
    Variable,
    None
}
enum WhetherCode{
    CL,
    BR,
    FG,
    RA,
    SHRA,
    SN,
    SHSN,
    TS,
    DZ,
    HZ,
    HL
}