package nowcoder;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/2/22 下午2:26
 * Blog: coderdaily.net
 * <p>
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution_02 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        int i = -1;
        while (++i < str.length()) {
            if (str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution_02 s = new Solution_02();
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        String result = s.replaceSpace(stringBuffer);
        System.out.println(result);
    }
}
