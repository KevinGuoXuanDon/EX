package leetcode.DoublePointer;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class ClosestThreeSum {
    // 思路：一眼双指针，时间复杂度O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 10000;
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int caculate = nums[i]+nums[left]+nums[right];
                if(Math.abs(caculate-target)<Math.abs(closest-target)){
                    closest = caculate;
                }
                if(caculate==target) return caculate;
                else if(caculate<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return closest;
    }
}
