import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class UseAtomic {


    int v = 10;
    private AtomicInteger value = new AtomicInteger(v);

    UseAtomic(int i){
        v = i;
    }


    public static void main(String[] args) {
        UseAtomic ua = new UseAtomic(4);
        System.out.println(ua.value.decrementAndGet());
    }

}
