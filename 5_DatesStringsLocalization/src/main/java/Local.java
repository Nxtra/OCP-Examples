import java.util.Locale;

public class Local {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        Locale l1 = new Locale("fr", "FR");
        System.out.println(l1);
        Locale l2 = new Locale.Builder()
                .setLanguage("fr")
                .setRegion("FR")
                .build();
        System.out.println(l2);


    }
}
