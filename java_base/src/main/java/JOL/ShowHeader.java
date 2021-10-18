package JOL;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author
 * @date 2021年10月06日 22:54
 * @description 查看java对象头信息
 */
public class ShowHeader {


    public static void main(String[] args) {
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

    static class T{
        int a;
        int b;
        boolean c;
//        short d;
//        float e;
//        double f;
        String str = "hello";
    }
}

