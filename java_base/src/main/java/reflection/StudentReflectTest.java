package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentReflectTest {


    public static void main(String[] args) throws ClassNotFoundException {


        /**
         * 第一种方法是通过类的全路径字符串获取 Class 对象，这也是我们平时最常用的反射获取 Class 对象的方法；
         * 第二种方法有限制条件：需要导入类的包；
         * 第三种方法已经有了 Student 对象，不再需要反射。
         */

        //通过字符串获取class对象
        Class studentClass = Class.forName("reflection.Student");

        // 通过类的class属性
        Class studentClass2 = Student.class;
        Student studentObject = new Student();

        //通过对象的class函数
        Class studentClass3 = studentObject.getClass();

        System.out.println("class1 = " + studentClass + "\n" +
                "class2 = " + studentClass2 + "\n" +
                "class3 = " + studentClass3 + "\n" +
                "class1 == class2 ? " + (studentClass == studentClass2) + "\n" +
                "class2 == class3 ? " + (studentClass2 == studentClass3));


        System.out.println("=================================");


        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declared filed:" + declaredField);
        }

        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println("Field:" + field);
        }


        Constructor[] constructors = studentClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("declare constructor:" + constructor);
        }


        Constructor[] constructors1 = studentClass.getConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("constructor:" + constructor);
        }


        Method[] declareMethods = studentClass.getDeclaredMethods();
        for (Method declareMethod : declareMethods) {
            System.out.println("declareMethod:" + declareMethod);
        }


        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println("method:" + method);
        }


    }
}
