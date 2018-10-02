package bounds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpperBounds {

    public static void main(String[] args) {
        List<? super IOException> exceptionList = new ArrayList<Exception>();
        //exceptionList.add(new Exception()); exceptionList could be of type List<IOException> and so Exception wouldn't fit
    }
}
