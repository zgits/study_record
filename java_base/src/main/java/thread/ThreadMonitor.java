package thread;

import java.util.Map;

/**
 * @author
 * @date 2021年08月07日 21:58
 * @description 查看运行线程所有信息
 */
public class ThreadMonitor {


    public static void main(String[] args) {

        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stackTraceElements = stackTrace.getValue();

            System.out.println("线程：" + thread.getName());
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println(stackTraceElement);
            }
        }
    }


}
