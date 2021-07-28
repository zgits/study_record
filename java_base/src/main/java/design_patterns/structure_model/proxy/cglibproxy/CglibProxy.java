package design_patterns.structure_model.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author
 * @date 2021年07月28日 20:24
 * @description
 */
public class CglibProxy implements MethodInterceptor {


    private Enhancer enhancer = new Enhancer();



    public Object getProxy(Class clazz) {


        // 设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }



    /**
     * 拦截所有目标类方法调用
     * @param o 目标类的实例
     * @param method 目标方法的反射对象
     * @param objects 目标方法的参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("日志开始");
        methodProxy.invokeSuper(o, objects);
        System.out.println("日志结束");

        return null;
    }
}
