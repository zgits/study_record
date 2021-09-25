package data_structure.sorts;

import java.util.Arrays;

/**
 * @author
 * @date 2021年09月25日 23:13
 * @description 十种排序算法实现
 */
public class Sort {


    /**
     * 冒泡排序
     * @param arr
     * @param upTime 是否进行优化
     */
    public static void bubbleSort(int[] arr,boolean upTime) {

        boolean swap = false;
        for (int i = 1; i < arr.length; i++) {
            swap = false;
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap && upTime) {

                break;
            }
        }
    }


    /**
     * 选择排序
     * @param arr
     */
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
     * @param arr
     */
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
     * @param arr
     */
    public static void shellSort(int[] arr) {


        for (int d = arr.length / 2; d >= 1; d /= 2) {


            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }



            }

        }
    }


    /**
     * 归并排序
     * @param arr
     */
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
        int j = mid+1;
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


    public static void main(String[] args) {

        int[] arr = {0,10,87,1,5,4,9,8,4,77,15,32};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));



    }




}
