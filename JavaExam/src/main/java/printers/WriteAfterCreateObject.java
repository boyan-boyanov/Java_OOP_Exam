package printers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAfterCreateObject {

    public WriteAfterCreateObject() {

    }

    public void saveToFile(String data, String document) {
        String directory = "src/main/java/output/";
        String filename = directory + document + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
