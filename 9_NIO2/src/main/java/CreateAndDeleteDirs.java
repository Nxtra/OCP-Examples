import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class CreateAndDeleteDirs {

    public static void main(String[] args) {

        Path path = Paths.get("9_NIO2/src/main/resources/level1a/level2a/../../level1b/../level1c/level2b/level3a");
        Path current = Paths.get("9_NIO2/src/main/resources/");

        try {
            Files.createDirectories(path);

            CreateAndDeleteDirs.walkAndPrint(current);

            System.out.println("Number of subdirs: " + CreateAndDeleteDirs.countSubDirs(current));

            CreateAndDeleteDirs.deleteDirectoryStream(current);

            System.out.println("Deleted dirs");

            System.out.println("Number of subdirs: " + CreateAndDeleteDirs.countSubDirs(current));

        } catch (IOException e ) {
            System.out.println("Cannot create directories: " + e);
        }
    }

    private static void walkAndPrint(Path path) throws IOException{
        Files.walk(path)
                .filter(p -> Files.isDirectory(p))
                .map(p -> p.toAbsolutePath())
                .forEach(System.out::println);
    }

    private static void deleteDirectoryStream(Path path) throws IOException {
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .filter(p -> p != path)
                .map(Path::toFile)
                .forEach(File::delete);
    }

    private static long countSubDirs(Path path) throws IOException{
        return Files.find(
                path,
                100,  // how deep do we want to descend
                (p, a) -> a.isDirectory()
        ).count() - 1;
    }
}
