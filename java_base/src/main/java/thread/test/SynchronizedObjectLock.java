package thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2021年09月22日 22:38
 * @description
 */
public class SynchronizedObjectLock implements Runnable{

    static SynchronizedObjectLock instence = new SynchronizedObjectLock();


    @Override
    public void run() {

        // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
        synchronized (this) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {

        SynchronizedObjectLock synchronizedObjectLock = new SynchronizedObjectLock();
        synchronizedObjectLock.run();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> synchronizedObjectLock.);
//        executorService.execute(() -> synchronizedObjectLock.func1());
    }
}
