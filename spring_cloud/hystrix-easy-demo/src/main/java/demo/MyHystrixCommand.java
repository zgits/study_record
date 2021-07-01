package demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author
 * @date 2021年06月28日 21:35
 * @description
 */
public class MyHystrixCommand extends HystrixCommand<String> {
    private final String name;


    public MyHystrixCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().
                        withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.name = name;
    }
    @Override
    protected String run() throws InterruptedException {
        System.err.println("get Data");
        return this.name + ":" + Thread.currentThread().getName();
    }


    @Override
    protected String getFallback() {
        return "失败了 ";
    }


    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand("zhangsan").execute();
        System.out.println(result);
        Future<String> future= new MyHystrixCommand("zhangsan").queue();
        System.out.println(future.get());

        hystrixRequestContext.shutdown();
    }
}
