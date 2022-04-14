package leetcode.Windows;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 */
public class ShortestSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0) return 0;
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int minLen = Integer.MAX_VALUE;
        while(right<nums.length){
            if(sum<target){
                right++;
                if(right == nums.length) break;
                sum+=nums[right];
            }
            if(sum>=target){
                minLen = Math.min(minLen,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        else return minLen;
    }
}
