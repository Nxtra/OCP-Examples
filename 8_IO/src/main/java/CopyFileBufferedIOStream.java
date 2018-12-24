import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class CopyFileBufferedIOStream {

    public static void main(String[] args) throws IOException {
        File originalFile = new File("./8_IO/src/main/resources/Original.txt");
        File newFile = new File(originalFile.getParent(), "New.txt");

        System.out.println("File exists: " + originalFile.exists());

        try(BufferedWriter out = new BufferedWriter(new FileWriter(originalFile))){
            out.write("hello");
            out.newLine();
            out.write("there");
        }

        try(InputStream in = new BufferedInputStream(new FileInputStream(originalFile));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))){

            byte[] buffer = new byte[128];
            int left;
            // read will return the number of chars read or -1 when the stream has reached the end
            while((left = in.read(buffer)) != -1){
                out.write(buffer, 0, left);
                out.flush();
            }
        }

        System.out.println("File exists: " + originalFile.exists());
    }
}
