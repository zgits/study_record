package data_structure.sorts;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * @author
 * @date 2021年09月25日 23:13
 * @description 十种排序算法实现
 */
public class Sort {


    /**
     * 冒泡排序
     *
     * @param arr
     */
    @Name(name = "冒泡排序")
    public static void bubbleSort(int[] arr) {

        boolean swap = false;
        for (int i = 1; i < arr.length; i++) {
            swap = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {

                break;
            }
        }
    }


    /**
     * 选择排序
     *
     * @param arr
     */
    @Name(name = "选择排序")
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }

    }


    /**
     * 插入排序
     *
     * @param arr
     */
    @Name(name = "插入排序")
    public static void insertionSort(int[] arr) {


        // 0 位置默认有序
        for (int i = 1; i < arr.length; i++) {

            //待插入数据
            int value = arr[i];

            //
            int j = i;


            // 从当前位置从后往前比较，如果前一个数比当前这个数大，把前一个数往后移动一位
            while (j > 0 && value < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = value;
            }

        }

    }


    /**
     * 希尔排序
     *
     * @param arr
     */
    @Name(name = "希尔排序")
    public static void shellSort(int[] arr) {
        for (int d = arr.length / 2; d >0; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j + d] = temp;
                    }
                }

            }

        }
    }


    /**
     * 归并排序
     *
     * @param arr
     */
    @Name(name = "归并排序")
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, arr.length - 1);

    }
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        merge_sort_recursive(arr, result, start, mid);
        merge_sort_recursive(arr, result, mid + 1, end);


        int index = start;
        int j = mid + 1;
        int i = start;
        while (i <= mid && j <= end) {
            result[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            result[index++] = arr[i++];
        }
        while (j <= end) {
            result[index++] = arr[j++];
        }

        for (index = start; index <= end; index++) {
            arr[index] = result[index];
        }

    }


    /**
     * 快速排序
     *
     * @param arr
     */
    @Name(name = "快速排序")
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    static void qSort(int[] arr, int left, int right) {


        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        qSort(arr, left, index);
        qSort(arr, index + 1, right);


    }
    static int partition(int[] arr, int left, int right) {

        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = pivot;
        return left;

    }


    /**
     * 堆排序 待理解
     *
     * @param arr
     */
    @Name(name = "堆排序")
    public static void heapSort(int[] arr) {
        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 计数排序
     *
     * @param arr
     */
    @Name(name = "计数排序")
    public static void countSort(int[] arr) {

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] bucket = new int[max - min + 1];

        for (int i : arr) {
            bucket[i - min]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i + min;
                bucket[i]--;
            }
        }
    }


    /**
     * 桶排序 待理解
     * @param arr
     */
    @Name(name = "桶排序")
    public static void bucketSort(int[] arr) {
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / 10) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / 10);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
           insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

    }
    static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    /**
     * 基数排序，待理解
     * @param arr
     */
    @Name(name = "基数排序")
    public static void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数
        int min = arr[0];

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
            if (anArr < min) {
                min = anArr;
            }
        }


        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] -= min;
                max -= min;
            }
        }

        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] += min;
            }
        }

    }





    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = Sort.class.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Name.class) != null) {
                if (method.getParameterTypes().length == 1 && method.getParameterTypes()[0] .isAssignableFrom(int[].class)) {
                    Name desc = method.getAnnotation(Name.class);
                    String sortDesc = desc.name();
                    int[] arr = new Random().ints(10, 100).limit(5).toArray();
                    int[] arr2 = Arrays.copyOf(arr, arr.length);
                    Arrays.sort(arr2);
                    String trueData = Arrays.toString(arr2);
                    System.out.println("=========" + sortDesc + "原始数据=========");
//                    System.out.println(Arrays.toString(arr));

                    long startTime =  System.currentTimeMillis();
                    method.invoke(null, arr);
                    long endTime =  System.currentTimeMillis();

                    System.out.println("==========" + sortDesc + "后数据=============");
                    System.out.println("  排序是否正确：" + Arrays.toString(arr).equals(trueData) + "  时间:" + (endTime - startTime)+"ms");
                    System.out.println();

                }
            } else {
                System.out.println(method.getName());
            }

        }
        int x = 10;
        if (x++ > 10 & x++ == 12) {
            ++x;
        }
        System.out.println(x);
    }


}


@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
@interface Name {
    public String name();
}
