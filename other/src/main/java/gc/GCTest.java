package gc;


/**
 * @author zjf
 * @desc 查看gc日志
 * 加入参数： -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC
 * -XX:+UseSerialGC 表示强制使用Serial+SerialOld收集器组合
 * -Xms20m 表示堆空间初始大小为 20 M。
 * -Xmx20m 表示堆空间最大大小为 20 M。
 * -Xmn10m 表示新生代大小为 10M。
 * -XX:SurvivorRatio=8 表示Eden:Survivor=8:1
 * -XX:+PrintGCDetails 打印详细GC信息
 * -XX:+PrintGCApplicationStoppedTime 打印应用由于GC而产生的停顿时间
 * -XX:+PrintGCApplicationConcurrentTime  打印应用程序的执行时间
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 *
 * [GC (Allocation Failure)  6445K->4760K(19456K), 0.0028401 secs]
 * 该日志显示 GC前 堆空间使用量为6m左右，gc后堆空间为 4760k，可使用堆大小为 19m左右
 */
public class GCTest {

    public static void main(String[] args) {


//        while (true) {
//            System.out.println("second allocate");
//        }
        // allocate 4M space
        while (true) {
            byte[] b = new byte[4 * 1024 * 1024];
            System.out.println("first allocate");
            // allocate 4M space
            b = new byte[4 * 1024 * 1024];
            System.out.println("second allocate");
        }


    }
}
