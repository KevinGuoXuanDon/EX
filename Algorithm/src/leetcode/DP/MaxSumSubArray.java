package leetcode.DP;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 */
public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length ==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // dp[i] 表示上一个以i结尾的连续子数组的最大和
        int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}

