import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UseJava8 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./");


        Files.find(path, 100,
                (p, a) -> p.toString().endsWith(".txt"))
                .forEach(System.out::println);

        Files.walk(path)
                .filter(p -> p.toString().endsWith(".java") && Files.isRegularFile(p))
                .forEach(System.out::println);

        Files.list(path)
                .filter(p -> Files.isDirectory(p))
                .map(p -> UseJava8.toReal(p))
                .forEach(System.out::println);
    }

    private static Path toReal(Path p){

        try {
            return p.toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
