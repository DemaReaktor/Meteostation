import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

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

        while (cellIterator.hasNext()){
cell =   cellIterator.next();
if(cell.getCellTypeEnum()!=CellType._NONE)
switch (cell.getColumnIndex()){
    case 0:
        meteo.setDay((int)cell.getNumericCellValue());
        break;
    case 1:
        Date date = cell.getDateCellValue();
        meteo.setHour(date.getHours());
        meteo.setMinute(date.getMinutes());
        break;
    case 2:
        meteo.setTemperature((int)cell.getNumericCellValue());
        break;
    case 3:
        switch (cell.getStringCellValue()){
            case "Южный":
                meteo.setWind(Wind.South);
                break;
            case "Северный":
                meteo.setWind(Wind.North);
                break;
            case "Западный":
                meteo.setWind(Wind.West);
                break;
            case "Восточный":
                meteo.setWind(Wind.East);
                break;
            case "С-В":
                meteo.setWind(Wind.N_E);
                break;
            case "С-З":
                meteo.setWind(Wind.N_W);
                break;
            case "Ю-В":
                meteo.setWind(Wind.S_W);
                break;
            case "Ю-З":
                meteo.setWind(Wind.S_E);
                break;
            case "Переменный":
                meteo.setWind(Wind.Variable);
                break;
        }
        break;
    case 4:
        meteo.setWindSpeed((int)cell.getNumericCellValue());
        break;
    case 5:
        meteo.setWhetherCode(cell.getStringCellValue());
        break;
    case 6:
        meteo.setNumberOfClouds((int)cell.getNumericCellValue());
        break;
    case 7:
        switch (cell.getCellTypeEnum()){
            case NUMERIC:
                meteo.setRangeOfVision(cell.getNumericCellValue());
                break;
            default:
                meteo.setRangeOfVision(Double.parseDouble(cell.getStringCellValue()));
                break;
        }
        break;
    case 8:
        meteo.setRelativeHumidity((int)cell.getNumericCellValue());
        break;
    case 9:
        meteo.setAtmosphericPressure((int)cell.getNumericCellValue());
        break;
    case 10:
        meteo.setLowerLimitOfClouds((int)cell.getNumericCellValue());
        break;
}
        }

    datas.add(meteo);
    }
    index++;
    }
        MeteoData[] f=new MeteoData[datas.size()];
        return datas.toArray(f);
    }
}
