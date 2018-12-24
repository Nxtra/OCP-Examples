import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileBufferedRW2 {

    private List<String> readFile(String source) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(source))){
            List<String> listOfData = new ArrayList<>();
            String d;
            while((d = br.readLine()) != null){
                listOfData.add(d);
            }
            return listOfData;
        }
    }

    private void writeFile(List<String> listOfData, String target ) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(target))){
            for(String str: listOfData){
                bw.write(str);
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CopyFileBufferedRW2 copyMachine = new CopyFileBufferedRW2();
        List<String> data = copyMachine.readFile("original.txt");
        copyMachine.writeFile(data, "new.txt");
    }
}
