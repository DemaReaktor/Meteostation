import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MeteoDataArrayExelEncoder {

    public static MeteoData[] read(String fileName, int start, int month)throws Exception{
        FileInputStream inputStream = new FileInputStream(new File(fileName));

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        LinkedList<MeteoData> datas = new LinkedList<>();
int index =1;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
if(start<=index){
    Iterator<Cell> cellIterator = row.cellIterator();
        Cell cell;
        MeteoData meteo = new MeteoData();

        meteo.setMonth(month);
        //day
        cell =  cellIterator.next();
        meteo.setDay((int)cell.getNumericCellValue());

        //hour and minute
        cell =  cellIterator.next();
    Date date = cell.getDateCellValue();
        meteo.setHour(date.getHours());
        meteo.setMinute(date.getMinutes());

    //temperature
    cell =  cellIterator.next();
    meteo.setTemperature((int)cell.getNumericCellValue());

    //wind
    cell =  cellIterator.next();
    meteo.setWind(cell.getStringCellValue());

    //speed
    cell =  cellIterator.next();
    meteo.setWindSpeed((int)cell.getNumericCellValue());

    //code
    cell =  cellIterator.next();
    meteo.setWhetherCode(cell.getStringCellValue());

    //number
    cell =  cellIterator.next();
    meteo.setNumberOfClouds((int)cell.getNumericCellValue());

    //rangeOfVision
    cell =  cellIterator.next();
    meteo.setRangeOfVision(cell.getNumericCellValue());

    //relativeHumidity
    cell =  cellIterator.next();
    meteo.setNumberOfClouds((int)cell.getNumericCellValue());

        datas.add(meteo);
    }
    index++;
    }
        return (MeteoData[])datas.toArray();
    }
}
