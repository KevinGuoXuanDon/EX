package leetcode.Array;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的
 * 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 */
public class EqualOrMoreTarget {
    //直接滑动窗口解决，注意滑动窗口的使用是因为这是"正整数"数组
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                count = Math.min(count, right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return count==Integer.MAX_VALUE? 0:count;
    }
}
