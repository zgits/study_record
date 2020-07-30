/**
 * @Description: 牛客网剑指offer第一题，二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 20:16.
 */
public class N_1 {
    public boolean Find(int target, int [][] array) {


        /**
         * 解题思路
         * 二维数组的折半查找，二维数组是有序的，选最后一行的第一个元素，与之比较
         * 大于就上一行，小于就比较下一个
         */
        int len=array.length-1;
        int i=0;
        while (len>=0&&i<array[0].length){
            if(array[len][i]>target){
                len--;
            }else if(array[len][i]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }
}
