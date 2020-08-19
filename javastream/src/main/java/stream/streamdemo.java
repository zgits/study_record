package stream;


import java.util.ArrayList;
import java.util.List;

public class streamdemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        long count = list.stream().filter(number -> number>50).count();
        System.out.println(count);
    }
}