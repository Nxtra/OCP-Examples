package AdvancedConcepts.collectors;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class KeepNewest {

    static File fileA = new File(763426800000L, "1994 content");
    static File fileB = new File(882831600000L, "1997 content");
    static File fileC = new File(1513983600000L, "2017 content");
    static File fileD = new File(1545519600000L, "2018 content");

    // 946681200000L is beginning of year 2000
    public static void main(String[] args) {
        Set<File> fileSet = new HashSet<>(Arrays.asList(fileA, fileB, fileC, fileD));
        keepNewest(fileSet, 946681200000L).forEach(System.out::println);

    }

    private static Set<File> keepNewest(Set<File> fileSet, long oldestTime) {
        return fileSet.stream()
                .filter(f -> f.getTimestamp() > oldestTime)
//                .collect(Collectors.toCollection(() -> new TreeSet<File>((File a, File b) -> a.compareTo(b))));
                .collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparingLong(File::getTimestamp))));
    }


    @AllArgsConstructor
    static class File implements Comparable<File>{
        private final long timestamp;
        private final String content;

        public File create(long timestamp, String content) {
            return new File(timestamp, content);
        }

        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public int compareTo(File other) {
            if(this.getTimestamp() > other.getTimestamp())
                    return 1;
            if(this.getTimestamp() < other.getTimestamp())
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "File{" +
                    "timestamp=" + timestamp +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
