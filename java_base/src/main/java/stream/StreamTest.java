package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author
 * @date 2021年08月17日 22:59
 * @description
 */
public class StreamTest {


    public static void main(String[] args) {
        new Thread(() -> {

            System.out.println("test");

        }).start();



        List<Demo> features = new ArrayList<>();
        features.add(new Demo(1, "1111"));
        features.add(new Demo(2, "1111"));
        features.add(new Demo(3, "1111"));
        features.add(new Demo(4, "1111"));


        features.stream().filter(demo -> demo.getAge()>2)
                .sorted(Comparator.comparing(Demo::getAge).reversed())
                .map(Demo::getAge)
                .count();

        features.sort(Comparator.comparing(Demo::getAge).thenComparing(Demo::getName));


        System.out.println(features.stream().map(Demo::getName).reduce( (a, b) -> a.concat("; " + b)).get());
        System.out.println(features.stream().map(Demo::getName).collect(Collectors.joining("; ")));
    }



}
class Demo {


    private int age;
    private String name;

    public Demo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

