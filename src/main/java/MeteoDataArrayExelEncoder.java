import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

//TODO Fix errors
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

    public static void write(MeteoData[] data,String fileName, int start) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        int rownum = start-1;
        Row row;

        for (MeteoData element : data) {
            rownum++;
            row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue(element.getDay());
                row.createCell(1, CellType.STRING).setCellValue(element.getHour().toString()+
                        ":"+element.getMinute().toString());
            if(element.getTemperature()!=null)
                row.createCell(2, CellType.NUMERIC).setCellValue(element.getTemperature());
            if(element.getWind()!=null)
                row.createCell(3, CellType.STRING).setCellValue(element.getWind().toString());
            if(element.getWindSpeed()!=null)
                row.createCell(4, CellType.NUMERIC).setCellValue(element.getWindSpeed());
            if(element.getWhetherCode()!=null)
            {
                String str="";
                boolean f=true;
                for(WhetherCode code:element.getWhetherCode()){
                    if(f)
                        f=false;
                    else
                        str+="+";
                    str+=code.toString();
                }
                row.createCell(5, CellType.STRING).setCellValue(str);
            }
            if(element.getNumberOfClouds()!=null)
                row.createCell(6, CellType.NUMERIC).setCellValue(element.getNumberOfClouds());
            if(element.getRangeOfVision()!=null)
                row.createCell(7, CellType.NUMERIC).setCellValue(element.getRangeOfVision());
            if(element.getRelativeHumidity()!=null)
                row.createCell(8, CellType.NUMERIC).setCellValue(element.getRelativeHumidity());
            if(element.getAtmosphericPressure()!=null)
                row.createCell(9, CellType.NUMERIC).setCellValue(element.getAtmosphericPressure());
            if(element.getLowerLimitOfClouds()!=null)
                row.createCell(10, CellType.NUMERIC).setCellValue(element.getLowerLimitOfClouds());
    }
        File file = new File("Data.xls");
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
}
}
