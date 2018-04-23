package soft_uni.products_shop.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

    public static void writeToFile(String fileName, String source) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/jsonOutput/" + fileName;
        FileWriter writer = new FileWriter(new File(path));
        writer.write(source);
        writer.flush();
    }
}
