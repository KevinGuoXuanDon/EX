package day9DynamicProgramming;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 */
public class MaxSubArray42 {
    // 很遗憾这种解决思路不算动态规划，而是对于当前值做了一个分类讨论。在当前值大于0的时候肯定要加上，并且判断是否更新maxResult
    // 在小于0时，如果当前值不会陷入负数，则接着往后推；否则接着连续的话当前值肯定是负的，直接归0从下个值开始计算。（这里也要判断最大值是否更新，如果最大值是负的也得更新）
    // 1ms 96.62%
    // 44.9mb 54.50%
    public int maxSubArray(int[] nums){
        if(nums==null) return -1;
        int maxResult = nums[0];
        int currentResult = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=0){
                currentResult+=nums[i];
                if(currentResult>maxResult) maxResult=currentResult;
            }
            else{
                if(maxResult<0) maxResult=Math.max(maxResult,nums[i]);
                if(currentResult+nums[i]<0){
                    currentResult=0;
                    continue;
                }
                currentResult+=nums[i];
            }
        }
        return maxResult;
    }


    /*
    采用动态规划。任意一个子数组，都会以这个数组中的某一个数字结尾。
    如果我们定义dp[i]表示为以nums[i]结尾的连续子数组的最大和，此时nums[i]必须被选取.
    此时需要对之前得到的子数组进行讨论：
    dp[i-1]>0, dp[i] = dp[i-1]+nums[i]
    dp[i-1]<=0, dp[i] = nums[i],因为nums[i]必须选取，所以前面的负数不如放弃
    所以状态转移方程 dp[i] = Math.max(dp[i-1]+nums[i], nums[i])
    */
    //1ms 96.52%
    //44.8MB 71.00%
    public int maxSubArray1(int[] nums){
        if(nums.length==0) return -1;
        int[] dp = new int[nums.length];
        int maxResult=nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            maxResult=Math.max(dp[i],maxResult);
        }
        return maxResult;
    }
    //节省数组内存
    //1ms 96.62%
    //45.1MB 怎么还更大了？？？？
    public int maxSubArray2(int[] nums){
        int maxResult=nums[0],preResult=0;
        for (int i:nums) {
            preResult=Math.max(nums[i]+preResult,nums[i]);
            maxResult=Math.max(preResult,maxResult);
        }
        return maxResult;
    }

    //44.8MB 71.00% 原数组上修改
    public int maxSubArray3(int[] nums){
        int maxResult=nums[0];
        for (int i=1;i< nums.length;i++) {
            nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
            maxResult=Math.max(maxResult,nums[i]);
        }
        return maxResult;
    }
}
