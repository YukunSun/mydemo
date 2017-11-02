package array;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/9/12 下午8:37
 * Blog: coderdaily.net
 */
public class InsersionSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 3, 12};
        new InsersionSort().sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    private void sort(int[] nums) {
//        int r, p = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            if (nums[j - 1] > temp) {
                while (j >= 1 && nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                    j--;
                }
            }
            nums[j] = temp;
        }
    }
}

