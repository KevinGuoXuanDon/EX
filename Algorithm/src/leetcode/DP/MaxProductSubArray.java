package leetcode.DP;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp = new int[nums.length][2];
        // dp[0][0]表示第0位结束时得到的乘积最小值，dp[0][1]表示第0位结束时乘积最大值
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int max = dp[0][0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                dp[i][0] = Math.min(dp[i-1][0]*nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i-1][1]*nums[i],nums[i]);
            }
            else{
                dp[i][0] = Math.min(dp[i-1][1]*nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i],nums[i]);
            }
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        return max;
    }
}
