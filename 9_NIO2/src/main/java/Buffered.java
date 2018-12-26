import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Buffered {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("original.txt");
        try(BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())){
            String currentLine = null;
            while((currentLine = br.readLine()) != null){
                System.out.println(currentLine);
            }
        }
    }
}
