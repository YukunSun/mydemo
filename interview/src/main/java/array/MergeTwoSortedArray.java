package array;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-07-02 09:56
 * Blog: coderdaily.net
 * <p>
 * 两个升序数组，合并成一个升序数组
 */
public class MergeTwoSortedArray {
    public static int[] merge(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        int[] c = new int[lengthA + lengthB];
        int i = 0, j = 0, k = 0;
        while (i < lengthA && j < lengthB) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < lengthA) {
            c[k++] = a[i++];
        }
        while (j < lengthB) {
            c[k++] = b[j++];
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6};
        int[] b = {3, 5, 7, 9, 10};
        int[] c = merge(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
