package nowcoder;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author: sun.yukun@foxmail.com
 * Time: 2018/2/11 下午3:53
 * Blog: coderdaily.net
 * <p>
 * 1.从左下角或右上角进行查询，因为如果从另外两个角查询的话，可能会产生分叉，不好判断。
 * 2.不一定是方块矩阵
 */
public class Solution_01 {
    /**
     * i :行，j:列
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        int dimen_j = array[0].length - 1;
        int dimen_i = array.length - 1;
        for (int i = dimen_i, j = 0; i >= 0 && j <= dimen_j; ) {
            int p = array[i][j];
            if (target == p) {
                return true;
            }
            if (target < p) {
                i--;
                continue;
            }
            if (target > p) {
                j++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_01 solution = new Solution_01();
        int[][] array = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        boolean result = solution.find(2, array);
        System.out.println(result);
    }
}
