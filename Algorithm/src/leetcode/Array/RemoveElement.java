package leetcode.Array;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 */
public class RemoveElement {
    // 妙手,直接占位
    public int removeElement(int[] nums, int val){
        int idx = 0;
        for(int i:nums){
            if(i!=val){
                nums[idx] = i;
                idx++;
            }
        }
        return idx;
    }

    // 俗手,替换+排序
    public int removeElementByForce(int[] nums, int val) {
        int len = nums.length;
        int count = len;
        for(int i=0;i<len;i++){
            if(nums[i]==val){
                nums[i]=Integer.MAX_VALUE;
                count--;
            }
        }
        Arrays.sort(nums);
        return count;
    }
}
