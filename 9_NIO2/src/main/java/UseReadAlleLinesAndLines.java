import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UseReadAlleLinesAndLines {

    public static void main (String[] args) throws IOException {
        Path path = Paths.get("original.txt");

        Files.readAllLines(path).forEach(System.out::println);

        Files.lines(path).filter(s -> s.startsWith("h")).forEach(System.out::println);
    }
}
