/**
 * @author
 * @date 2021年08月28日 17:14
 * @description
 */
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        boolean badInput = false;
        if (n > 1 && n <= 23) {
            int[] nums = new int[n];
            while (n > 0) {
                n--;
                nums[n] = sc.nextInt();
                if (nums[n] < 1 || nums[23] > 23) {
                    badInput = true;
                    break;
                }
            }
            if (!badInput) {
                for (int j = 0; j < nums.length; j++) {
                    int addResult = nums[j];
                    for (int i = j + 1; i < nums.length; i++) {
                        int temp = nums[i];
                        if (addResult + temp == 24) {
                            count += 1;
                            addResult = addResult - temp;
                        } else if (addResult + temp > 24) {
                            continue;
                        } else {
                            addResult = addResult + temp;
                        }
                    }
                }
            }
        }
        System.out.println(count);




    }


//
//    String str= sc.nextLine();
//    char[] chars = new char[str.length()];
//    int[] count = new int[str.length()];
//
//    int nullIndex = -1;
//        for (int i = 0; i < str.length(); i++) {
//        char c = str.charAt(i);
//        int index = getIndex(chars, c);
//        if (index >= 0) {
//            count[index] += 1;
//        } else {
//            nullIndex++;
//            chars[nullIndex] = c;
//            count[nullIndex] = 1;
//
//
//        }
//    }
//
//    sort(chars,count);
//
//        for (int i = 0; i < count.length; i++) {
//        if (count[i] > 0) {
//            System.out.print(String.valueOf(chars[i]) + count[i]);
//        }
//    }

//    public static int getIndex(char[] chars, char c) {
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == c) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//    public static void sort(char[] chars, int[] count) {
//
//        for (int i = 0; i < chars.length; i++) {
//
//
//            char temp = chars[i];
//            int counttemp = count[i];
//            int position = i;
//
//            while (position > 0 && chars[position - 1] > temp) {
//                chars[position] = chars[position - 1];
//                count[position] = count[position - 1];
//                position--;
//            }
//            chars[position] = temp;
//            count[position] = counttemp;
//
//        }
//
//
//    }
}

enum Enumss{

    INSTAN(1){
        @Override
        public void de() {

        }
    };


    Enumss(int anInt) {
        this.anInt = anInt;
    }


    int anInt;


    public abstract void de();
}