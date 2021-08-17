package stream;

import java.util.stream.IntStream;

public class TestStreamAndParallelSpeed {

    public static void main(String[] args) {
        long t0 = System.nanoTime();

        int[] a = IntStream.range(0, 1_000_000).filter(x -> x % 2 == 0).toArray();

        long t1 = System.nanoTime();

        int[] b = IntStream.range(0, 1_000_000).parallel().filter(x -> x % 2 == 0).toArray();

        long t2 = System.nanoTime();

        System.out.printf("serial:" + (t1 - t0) + "parallel:" + (t2 - t1));

    }
}
