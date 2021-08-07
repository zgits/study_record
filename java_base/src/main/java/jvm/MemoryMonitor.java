package jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @author
 * @date 2021年08月07日 21:48
 * @description 通过java api或者jvm查看堆栈信息
 */
public class MemoryMonitor {





    public static void main(String[] args) {

        while (true) {
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
            System.out.println("INIT HEAP:" + memoryUsage.getInit() / 1024 / 1024 + "m");
            System.out.println("MAX HEAP:" + memoryUsage.getMax()/ 1024 / 1024 + "m");
            System.out.println("USE HEAP:" + memoryUsage.getUsed()/ 1024 / 1024 + "m");


            System.out.println("FULL INFOMATION:");


            System.out.println("HEAP Memory Usage:" + memoryMXBean.getHeapMemoryUsage());
            System.out.println("NON HEAP Memory Usage:" + memoryMXBean.getNonHeapMemoryUsage());


            System.out.println("================通过java来获取相关状态=======================");
            System.out.println("当前堆内存大小totalMemory:" + Runtime.getRuntime().totalMemory()/ 1024 / 1024 + "m");
            System.out.println("空闲堆内存大小freeMemory:" + Runtime.getRuntime().freeMemory()/ 1024 / 1024 + "m");
            System.out.println("最大可用总堆内存maxMemory:" + Runtime.getRuntime().maxMemory()/ 1024 / 1024 + "m");
        }

    }



}
