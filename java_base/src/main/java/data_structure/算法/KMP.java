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
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                //next[j]是j位公共前缀，下次移动直接移动时，next[j]位前面的一定是相同的，直接从j开始比较即可
                //j移动到next[j]=4，【因为[0~3]的4个字符是因为公共前后缀，所以j下次从[4]开始】
                j = next[j];
            }
        }

        if (j == target.length()) {
            return i - j;
        } else {
            return -1;
        }
    }


    int[] pst(String str) {
        int[] next = new int[str.length()];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < str.length() - 1) {
            // 错开一位匹配，刚好就是匹配前缀和后缀
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                ++j;
                ++i;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.KMP("cdacdd", "abababababab"));
        ;
    }


}
