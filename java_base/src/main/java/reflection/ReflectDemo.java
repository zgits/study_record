package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //通过字符串获取 student对象
        Class studentClass = Class.forName("reflection.Student");

        Constructor constructor = studentClass.getDeclaredConstructor(String.class);



        constructor.setAccessible(true);

        Object student=constructor.newInstance("nameA");

        Field age = studentClass.getDeclaredField("age");

        age.set(student, 10);

        Method studentShow = studentClass.getDeclaredMethod("show", String.class);
        studentShow.setAccessible(true);
        Object result = studentShow.invoke(student, "message");
        System.out.println(result);

    }
}
