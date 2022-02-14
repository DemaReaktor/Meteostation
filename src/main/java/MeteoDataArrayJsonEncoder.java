import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MeteoDataArrayJsonEncoder {
    public static void write(MeteoData[] array,String fileName) throws Exception{
        Files.write(Paths.get(fileName),new Gson().toJson(array).getBytes());
    }
    public static MeteoData[] read(String fileName) throws Exception{
        String str ="";
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for(String element:Files.readAllLines(Paths.get(fileName))) str+=element;
        return new Gson().fromJson(str, MeteoData[].class);
    }
}
