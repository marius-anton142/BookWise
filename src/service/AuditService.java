package service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private AuditService(){}
    public static void log(String action) {
        try {
            FileWriter fileWriter = new FileWriter("data/Log.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime timestamp = LocalDateTime.now();
            String formattedTimestamp = timestamp.format(formatter);

            bufferedWriter.write(action + ", " + formattedTimestamp);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
