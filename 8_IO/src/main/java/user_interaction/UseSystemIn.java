package user_interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseSystemIn {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.printf("Input was %s", input);
    }
}
