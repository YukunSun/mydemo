package array;

/**
 * 1.尽量不要使用JAVA已经封装好的类，例如ArrayList等。
 * 2.传参：值类型，引用类型。
 */
public class MoveZeroes_283 {
    /**
     * 借助了一个数组，和一个变量。
     * 时间复杂度O(n)，空间复杂度O(n)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        // FIXME: 2017/9/2 以如下方式赋值是不行的，因为相当于只是把arr的引用地址给了nums,其实并未改变nums[]的每个元素的实际值。
//        nums = arr;
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param nums
     */
    public void _moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    /**
     * 也可以使用交换的形式
     *
     * @param nums
     */
    public void __moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (insertPos != i) {
//                    nums[insertPos++] = nums[i];
                    swap(nums[insertPos++], nums[i]);
                }
                insertPos++;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    private void swap(int k, int i) {
        k = k + i;
        i = k - i;
        k = k - i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes_283().moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
