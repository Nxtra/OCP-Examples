package legacy;

import java.util.ArrayList;
import java.util.List;

public class LegacyReptile {

    public static void main(String[] args) {
        List<Reptile> reptiles = new ArrayList<>();
        addReptiles(reptiles);
        Reptile reptile = reptiles.get(0); //ClassCastException
    }

    private static void addReptiles(List reptileList) {
        reptileList.add(new Fish());
    }
}
