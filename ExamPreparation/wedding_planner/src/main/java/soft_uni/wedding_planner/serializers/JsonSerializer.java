package soft_uni.wedding_planner.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.*;

@Component(value = "JsonSerializer")
public class JsonSerializer {

    private static final String FILES_INPUT_DIRECTORY = "/src/main/resources/input/json/";
    private static final String FILES_OUTPUT_DIRECTORY = "/src/main/resources/output/json/";

    private Gson gson;

    public JsonSerializer() {
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();
    }

    public <T> T importFromFile(Class<T> classObj, String fileName) throws FileNotFoundException {


        String path = System.getProperty("user.dir") + FILES_INPUT_DIRECTORY + fileName;

        System.out.println("File path: " + path);
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path));

        T importFromJsonDTO = gson.fromJson(bufferedReader, classObj);
        return importFromJsonDTO;

    }

    public <T> void exportToFile(T t, String fileName) throws IOException {

        String path = System.getProperty("user.dir") + FILES_OUTPUT_DIRECTORY + fileName;

        System.out.println("File path: " + path);
        FileWriter writer = new FileWriter(path);

        writer.write(gson.toJson(t));
        writer.close();
    }
}
