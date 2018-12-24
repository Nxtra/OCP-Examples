import java.io.*;

public class CopyFileBufferedRW {

    public static void main(String[] args) throws IOException {

        File originalFile = new File("original.txt");
        File newFile = new File("new.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(originalFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
        }
    }
}
