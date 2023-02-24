package printers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintFile {
    private final String filename;
    private final String directory = "src/main/java/output/";

    public PrintFile() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm ss");
        this.filename = this.directory + "EmployeeSystem_OUT_" + now.format(formatter) + ".txt";
    }

    public void write(String contentLine) {
        try {
            this.createFolderAndFileIfNotExists();
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true));
            writer.write(contentLine);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFolderAndFileIfNotExists() {
        Path path = Paths.get(this.directory);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("An error occurred while creating the directory.");
                e.printStackTrace();
            }
        }
        Path file = Paths.get(this.filename);
        if (!Files.exists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }
    }
}
