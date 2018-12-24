package user_interaction;

import java.io.Console;

public class UseConsole {

    public static void main(String[] args) {
        Console console = System.console();
        if(console != null){
            String userInput = console.readLine();
            console.writer().printf("Input was %s", userInput);
        }
    }
}
