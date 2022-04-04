package leetcode.DP;

/**
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums，请计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * ®
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class StealHouse {
    public int rob(int[] nums) {
        //dp[i]表示对于一直到当前节点能偷到最多的钱。
        //那么对于当前房屋i，偷或者不偷。当前不偷，最多的钱就是截止到上一间屋子偷盗的最多的
        //偷的话，就是当前的钱+隔一间屋子的钱
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
