package arts;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/7/29 上午7:10
 * Blog: coderdaily.net
 */
public class TwoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (other == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum_01 t = new TwoSum_01();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = t.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
