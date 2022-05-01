package leetcode.Array.Prefix;

/**
 * 6052. 最小平均差
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 *
 * 下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。
 *
 * 请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
 *
 * 注意:
 * 两个数的 绝对差 是两者差的绝对值。
 *  n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
 * 0 个元素的平均值视为 0 。
 * 输入：nums = [2,5,3,9,5,3]
 * 输出：3
 * 解释：
 * - 下标 0 处的平均差为：|2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3 。
 * - 下标 1 处的平均差为：|(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2 。
 * - 下标 2 处的平均差为：|(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2 。
 * - 下标 3 处的平均差为：|(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0 。
 * - 下标 4 处的平均差为：|(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1 。
 * - 下标 5 处的平均差为：|(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4 。
 * 下标 3 处的平均差为最小平均差，所以返回 3
 */
public class MinAvgDifference {
    // 简直是前缀和的例题了
    public int minimumAverageDifference(int[] nums) {
        long ans = Integer.MAX_VALUE;
        int index = 0;
        int n= nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        for(int i=0; i<n-1; i++){
            long curAvg = Math.abs( prefix[i]/(i+1)-(prefix[n-1]-prefix[i])/(n-1-i) );
            if(curAvg<ans){
                ans = curAvg;
                index =i;
            }

        }
        long lastAvg = prefix[n-1]/n;
        if(lastAvg<ans){
            return n-1;
        }
        return index;
        // 2 7 10

    }
}
