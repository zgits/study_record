package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSpeed {


    public static void test01(){

        long startTime = System.currentTimeMillis();

        Student student = new Student();
        for (int i = 0; i < 1000000000; i++) {
            student.getAge();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通10亿" + (endTime - startTime));
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();

        Student student = new Student();
        Class c1 = student.getClass();
        Method method = c1.getDeclaredMethod("getAge", null);
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(student, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("安全检查10亿" + (endTime - startTime));
    }



    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();

        Student student = new Student();
        Class c1 = student.getClass();
        Method method = c1.getDeclaredMethod("getAge", null);
        method.setAccessible(true);
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(student, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("非安全检查10亿" + (endTime - startTime));
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }

}
