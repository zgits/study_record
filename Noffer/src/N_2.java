/**
 * @Description: 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 20:36.
 */
public class N_2 {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();

    }
}
