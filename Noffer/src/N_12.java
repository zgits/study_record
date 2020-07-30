/**
 * @Author: zjf
 * @Date: 2019/7/9 13:06
 * @Description: 二进制中1的个数
 */
public class N_12 {

    public static int NumberOf1(int n) {

        int count=0;
        int flag=1;
        while (flag!=0){
            if((flag&n)!=0){
                count++;
            }
            flag=flag<<1;
            System.out.println(flag);
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1(5);
    }

}
