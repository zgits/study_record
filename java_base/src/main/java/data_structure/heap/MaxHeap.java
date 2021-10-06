package data_structure.heap;

import java.util.LinkedList;

/**
 * @author
 * @date 2021年10月03日 14:12
 * @description
 */
public class MaxHeap {


    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {

        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }




}
