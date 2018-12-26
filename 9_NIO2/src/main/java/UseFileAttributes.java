import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public class UseFileAttributes {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("original.txt");


        // two ways to get the filleattributes on a file
        // when getting the file view you can modify the props
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes data = view.readAttributes();

        System.out.println("Filesize: " + data.size());
        System.out.println("LastAccessTime was: " + data.lastAccessTime());
        System.out.println("lastModifiedTime was: " + data.lastModifiedTime());

        waitALittle(3);

        FileTime now = FileTime.from(Instant.now());
        System.out.println("Now is: " + now);
        view.setTimes(null, now, null);

        FileTime lastMT = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 80_000);
        view.setTimes(lastMT    , null, null);

        BasicFileAttributes newData = view.readAttributes();

        System.out.println("LastAccessTime is " + newData.lastAccessTime());
        System.out.println("LastModifiedtime is " + newData.lastModifiedTime());

    }

    static void waitALittle(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


