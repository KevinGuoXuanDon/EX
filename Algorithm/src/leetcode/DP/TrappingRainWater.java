package leetcode.DP;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。*
 * 示例 1：
 * <p>
 * leetcode 42.
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = right[n - 1];
        // 对于每一个位置来说，左边的最大值是？
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        // 对于每一个位置来说，右边的最大值是?
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // 收集完了每一个位置的左边/右边最大值，和自己进行对比
        // 这个空缺处收集的雨水就是缺口（左/右最大值更小的那个） - 自己的高度
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
