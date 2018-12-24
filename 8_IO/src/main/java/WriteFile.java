import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteFile {

    public static void main(String[] args) throws IOException{

        File logFile = new File(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss").format(LocalDateTime.now()));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile))) {
            System.out.println("File was written to: "  + logFile.getCanonicalPath());
            bw.write("Time Check!");
        }
    }
}