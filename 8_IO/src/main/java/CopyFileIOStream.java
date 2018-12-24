import java.io.*;

public class CopyFileIOStream {

    public static void main(String[] args) throws IOException {
        File originalFile = new File("./8_IO/src/main/resources/Original.txt");
        File newFile = new File(originalFile.getParent(), "New.txt");

        System.out.println("File exists: " + originalFile.exists());

        try(BufferedWriter out = new BufferedWriter(new FileWriter(originalFile))){
            out.write("hello");
            out.newLine();
            out.write("there");
        }

        try(FileInputStream in = new FileInputStream(originalFile);
        OutputStream out = new FileOutputStream(newFile)){
            int i;

            while((i = in.read()) != -1){
                out.write(i);
            }
        }

        System.out.println("File exists: " + originalFile.exists());
    }
}
