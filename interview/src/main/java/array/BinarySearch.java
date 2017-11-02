package array;

/**
 * 0. 有序数组。
 * 1. 首先定义边界，循环不变量。
 */
public class BinarySearch {
    /**
     * 返回找到的下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midValue = arr[mid];
            if (target == midValue) {
                return mid;
            }
            if (target > midValue) {//左边的舍弃掉
                l = mid + 1;
            } else {//右面的舍弃掉
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int reslt = binarySearch(arr, 9);
        System.out.println(reslt);
    }
}
