package thread;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @date 2021年04月12日 20:36
 * @description 一段基于ReentrantLock锁的实现
 */
public class ReentrantLockExample {

    int a = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    Unsafe unsafe = Unsafe.getUnsafe();


    public void writer(){
        lock.lock();

        try {
            a++;
        }finally {
            lock.unlock();
        }
    }


    public void reader(){
        lock.lock();
        try {
            int i = a;
            System.out.println(i);
        }finally {
            lock.unlock();
        }

    }

}
