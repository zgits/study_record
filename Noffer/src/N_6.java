import java.util.Arrays;

/**
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 21:27.
 */
public class N_6 {
    public int minNumberInRotateArray(int [] array) {

        /**
         * 采用二分法做，此题为非常规做法
         */
        if(array.length==0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}
