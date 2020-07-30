/**
 * @Description: 青蛙变态跳
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/12 19:21.
 */
public class N_10 {
    public int JumpFloorII(int target) {

        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
