package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-05 17:04
 * Blog: coderdaily.net
 * @see https://leetcode.com/problems/two-sum/
 * 1.是否排序
 * 2.边界问题
 * 3.是否有多个结果
 * 4.相等怎么办
 */
public class Solution1 {
    //暴力遍历
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            for (int j = i + 1; j < nums.length; j++) {
                if (second == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {

        return null;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 2, 4};
        int[] nums = {2, 5, 5, 11};
        int target = 10;

        Solution1 solution = new Solution1();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
