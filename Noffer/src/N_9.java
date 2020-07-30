/**
 * @Description: 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 21:43.
 */
public class N_9 {
    public int JumpFloor(int target) {

        int a=1;
        int b=2;
        int result=0;
        if(target<=2){
            return target;
        }
        for (int i = 3; i <= target; i++) {
            result=a+b;
            a=b;
            b=result;
        }
        return result;
    }
}
