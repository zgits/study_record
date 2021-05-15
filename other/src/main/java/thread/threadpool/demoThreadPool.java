package thread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author
 * @date 2021年05月03日 15:19
 * @description
 */
public class demoThreadPool {


    public static void main(String[] args) {



        ExecutorService executorService = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3)
                , new ThreadFactoryBuilder().setNameFormat("test").build(), new ThreadPoolExecutor.DiscardPolicy());



        try{

            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            //此处设置的拒绝策略为AbortPolicy(),当处理线程都还没处理完第一轮所有请求的情况下，10个请求线程超过了最大线程数加阻塞队列最大值数
            //无法处理多出的请求，就会启动拒绝策略，这里会抛出异常
            for(int i=1;i<=10;i++){
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            executorService.shutdown();//关闭池子
        }
    }
}
