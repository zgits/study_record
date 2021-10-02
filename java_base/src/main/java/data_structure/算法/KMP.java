package data_structure.算法;


/**
 * @author
 * @date 2021年10月02日 16:49
 * @description 字符串匹配算法KMP
 */
public class KMP {

    int KMP(String target, String source) {
        int i = 0;
        int j = 0;
        int[] next = pst(target);
        while (i < source.length() && j < target.length()) {
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == target.length()) {
            return i - j;
        } else {
            return -1;
        }
    }


    int[] pst(String str) {
        int[] next = new int[str.length()];
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }

            if (str.charAt(j) == str.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.KMP("cdacdd", "ababa111bcdacddababab"));
        ;
    }


}
