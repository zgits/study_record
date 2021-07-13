package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author
 * @date 2021年07月12日 20:59
 * @description
 */
public class TestSpeed {



    public static void test01() {
        long startTime = System.currentTimeMillis();
        Student student = new Student();
        for (int i = 0; i < 1000000000; i++) {
            student.getAge();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通时间:" + (endTime - startTime));
    }




    public static void test02() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        long startTime = System.currentTimeMillis();

        Student student = new Student();
        Method method = student.getClass().getDeclaredMethod("getAge", null);
        method.setAccessible(true);
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(student, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通时间:" + (endTime - startTime));
    }




    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();

        Student student = new Student();
        Method method =  student.getClass().getDeclaredMethod("getAge", null);
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(student, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通时间:" + (endTime - startTime));
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
