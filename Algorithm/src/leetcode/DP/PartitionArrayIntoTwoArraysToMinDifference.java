package leetcode.DP;

/**
 * 把数组分成两个子数组，
 */
import java.util.Arrays;
public class PartitionArrayIntoTwoArraysToMinDifference {
    public int minimumDifference(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).min().getAsInt();
        for(int i:nums){
            i-=min;
        }
        int[][] dp = new int[nums.length][sum/2+1];
        for(int i =0; i<= sum/2;i++){
            if(nums[0]<i)
                dp[0][i] = nums[0];
        }
        for(int i=1; i<nums.length; i++){
            for(int j = 0; j<=sum/2; j++){
                if(nums[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+ nums[i]);
                }
            }
        }
        int i = dp[nums.length-1][sum/2];
        return Math.abs(sum-i-i);
    }
    /**
     * 如果此时题目要求分组必须是平均分成两份呢？
     * 0,1,2,3,4,16这个时候就无法解决， sum=26
     * 因为dp这个时候拆分的结果是 10 / 16
     * 而应该的拆分是 9/ 17
     *
     */

}
