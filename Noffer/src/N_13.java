/**
 * @Author: zjf
 * @Date: 2019/7/11 12:59
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class N_13 {
    public static double Power(double base, int exponent) {

        double result=base;
        while (exponent>1){

            result*=base;
            exponent--;
        }
        while (exponent<-1){
            result*=base;
            exponent++;
        }
        if (exponent<0){
            return 1/result;
        }
        if (exponent==0){
            return 1.0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2,3));
    }
}
