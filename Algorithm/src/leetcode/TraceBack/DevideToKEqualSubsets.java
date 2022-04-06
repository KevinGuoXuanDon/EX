package leetcode.TraceBack;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 */
public class DevideToKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(k>nums.length) return false;
        int count=0;
        for(int i:nums) count+=i;
        int target =0;
        if(count%k==0){
            target = count/k;
        }
        else return false;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int[] bucket = new int[k];
        return backTrace(nums,target,0,bucket);
    }
    public boolean backTrace(int[] nums, int target, int index, int[] bucket){
        if(index == nums.length){
            for(int j: bucket){
                if(j!=target) return false;
            }
            return true;
        }
        for(int i=0; i< bucket.length; i++){
            if(bucket[i]+nums[index]>target) continue;
            bucket[i]+=nums[index];
            if(backTrace(nums,target,index+1,bucket)) return true;;
            bucket[i]-=nums[index];
        }
        return false;
    }
}
