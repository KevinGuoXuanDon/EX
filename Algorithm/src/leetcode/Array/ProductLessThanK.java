package leetcode.Array;

/**
 * 给定一个正整数数组nums和整数 k，请找出该数组内乘积小于k的连续的子数组的个数。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 */
public class ProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int left = 0;
        int right = 0;
        int sum = 1;
        int count = 0;
        while(right<nums.length){
            sum*=nums[right];
            while(sum>=k){
                sum/=nums[left];
                left++;
            }
            count+= right-left+1;
            right++;

        }
        return count;
    }
}
