package dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author
 * @date 2021年06月21日 21:23
 * @description
 */
public class DynamicProxyTest {



    interface IHello{
        void sayHello();
    }


    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }


    static class DynamicProxy implements InvocationHandler {


        Object originObject;


        Object bind(Object o) {
            this.originObject = o;
            return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
        }



        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("proxy");
            System.out.println(proxy.getClass());
            return method.invoke(originObject, args);
        }
    }


    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();



    }



}
