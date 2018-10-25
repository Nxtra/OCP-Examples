import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HashIt {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("string", "sdkj");
        list.forEach(s -> System.out.println(s + "=" + s.hashCode()));

        Collections.sort(list, (o1, o2) -> (o1.hashCode() - o2.hashCode()));

        System.out.println("After Sorting");

        list.forEach(s -> System.out.println(s + "=" + s.hashCode()));
    }

    private static List<String> sortListOnHashKey(List<String> list){
        for (String s : list) {
            System.out.println(s + "=" + s.hashCode());
        }
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        System.out.println("After Sorting");
        for (String s : list) {
            System.out.println(s + "=" + s.hashCode());
        }

        return list;
    }
}
