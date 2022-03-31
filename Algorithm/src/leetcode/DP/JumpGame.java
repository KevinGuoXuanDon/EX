package leetcode.DP;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 
 *
 * 示例1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class JumpGame {
    // dp[i]=j; 表示在位置i时能够达到的最远距离.如果在当前位置为0时，
    // 就需要判断之前的位置能否达到更远的坐标。如果不能，则无法达到最后位置
    public boolean canJump(int[] nums) {
        if(nums.length<=1) return true;
        int[] dp = new int[nums.length];
        if(nums[0]==0) return false;
        dp[0]=nums[0];
        for(int i=1; i<nums.length-1; i++){
            if(nums[i]==0 && dp[i-1]<=i){
                return false;
            }
            dp[i] = Math.max(dp[i-1],i+nums[i]);
        }
        return true;
    }
}
