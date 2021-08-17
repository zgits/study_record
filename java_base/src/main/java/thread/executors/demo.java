package thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class demo {


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(
            () -> {
            // ... do something inside runnable task
            
        });
        service.shutdown();

        Thread.interrupted();

        Thread thread = Thread.currentThread();
        thread.interrupt();


        byte a = 1;
        byte b = 2;
//        byte c = a + b;

        IntStream.range(0, 1_000_000).filter(s -> s % 2 == 0).toArray();

    }
}
