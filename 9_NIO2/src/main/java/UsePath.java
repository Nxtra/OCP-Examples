import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class UsePath {

    public static void main(String[] args) throws IOException {
        Path desktop = Paths.get("Users/root/Desktop");

        IntStream.range(0, desktop.getNameCount())
                .forEach((i -> System.out.printf("Element %d is: %s " + System.lineSeparator(), i, desktop.getName(i))));

        System.out.println(Paths.get("."));
        System.out.println(Paths.get(".").toRealPath());
        System.out.println(Paths.get("./level1/level2/../../level1/.././level1/level2").normalize());
        System.out.println(Paths.get(".").toAbsolutePath());
    }
}
