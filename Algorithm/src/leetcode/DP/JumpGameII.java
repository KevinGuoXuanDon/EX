package leetcode.DP;

import java.util.Arrays;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳ss1ss步，然后跳ss3ss步到达数组的最后一个位置。
 */
public class JumpGameII {
    //dp[i]=j 表示从起点到这个位置，最小的跳跃步骤是多少
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =1 ; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
