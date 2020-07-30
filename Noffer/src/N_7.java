/**
 * @Description: 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 21:35.
 */
public class N_7 {
    public int Fibonacci(int n) {

        if(n<=1){
            return 0;
        }
        int[] fi=new int[n];
        fi[0]=1;
        fi[1]=1;
        for (int i = 2; i < n; i++) {
            fi[i]=fi[i-1]+fi[i-2];
        }
        return fi[n-1];
    }
}
