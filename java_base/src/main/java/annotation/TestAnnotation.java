package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author
 * @date 2021年06月20日 10:12
 * @description
 */

@Test
public class TestAnnotation {

    @Test(id=10)
    int a;


    @Test(msg = "testMethod")
    public String test() {
        return "";
    }


    public static void main(String[] args) {
        boolean haveAnnotation = TestAnnotation.class.isAnnotationPresent(Test.class);


        if (haveAnnotation) {
            Test annotation = TestAnnotation.class.getAnnotation(Test.class);
            System.out.println(annotation.id());
            System.out.println(annotation.msg());

        }


        try {
            Field a = TestAnnotation.class.getDeclaredField("a");
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Test test = a.getAnnotation(Test.class);
            if ( test != null ) {
                System.out.println("check value:"+test.id());
            }
            Method testMethod = TestAnnotation.class.getDeclaredMethod("test");
            if ( testMethod != null ) {
                // 获取方法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for( int i = 0;i < ans.length;i++) {
                    Test tests = (Test) ans[i];
                    System.out.println("cast:" + tests.msg());
                    System.out.println("method testMethod annotation:"+ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



}
