package thread.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author
 * @date 2021年04月27日 21:07
 * @description fork/join框架使用
 */
public class CountTask extends RecursiveTask<Integer> {


    //阀值
    private static final int THRESHOLD = 2;

    private int start;
    private int end;


    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;

        if (canCompute) {
            int j = 1 / 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阀值，就分裂成两个子任务计算

            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;



        }
        return sum;


    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask countTask = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(countTask);


        try {
            System.out.println(result.get());
            if (countTask.isCompletedAbnormally()) {
                System.out.println(countTask.getException());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
