package array;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/2/24 下午5:20
 * Blog: coderdaily.net
 * <p>
 * 翻转一个字符串
 */
public class ReverseString {
    public String getReverseString(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        char[] arr = str.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        String result = obj.getReverseString("abcdefg");
        System.out.println(result);
    }
}
