package stream;


import java.util.ArrayList;
import java.util.List;

public class streamdemo {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i);
//        }
//
//        MathOperation mathOperation =  (int a,int b)->{ return a * b;};
//
//        long count = list.stream().filter(number -> number>50).count();
//        System.out.println(count);


        int[] a = new int[64*1024*1024];

        long naotime = System.currentTimeMillis();

        for (int i = 0; i < a.length; i++) {
            a[i] *= 3;
        }

        long end1time = System.currentTimeMillis();

        System.out.println(end1time - naotime);


        for (int i = 0; i < a.length; i+=16) {
            a[i] *= 3;
        }
        System.out.println(System.currentTimeMillis() - end1time);




    }


    interface MathOperation {
        int operation(int a, int b);
    }


}