package util;

import java.time.Instant;

public class StopWatch {

    long start;
    long stop;
    long diff;

    public void start(){
        start = Instant.now().toEpochMilli();
    }


    public void stop(){
        stop = Instant.now().toEpochMilli();
    }

    public long getDiff(){
        diff = stop - start;
        return diff;
    }

}
