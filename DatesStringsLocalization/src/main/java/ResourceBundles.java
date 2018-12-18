import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {
    public static void main(String[] args) {
        Locale us = new Locale("en","US");
        Locale fr = new Locale("fr","FR");
        printProperties(us);
        printProperties(fr);
    }

    private static void printProperties(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store", locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("open"));
    }
}
