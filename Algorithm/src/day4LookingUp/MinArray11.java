package day4LookingUp;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 */
public class MinArray11 {
    //如果没左旋，直接返回第一位，如果左旋了，从后往前查找
    //0ms, 100%
    //38.3 31.34%
    //但是有一说一仔细想想还是不对，对于某些情况等于没做优化的暴力破解。
    //左旋一半一下的数字时候当然优化了，但是如果左旋一半以上的数字，查找效率反而更低
    public int minArray(int[] nums){
        if(nums==null) return -99999;
        if (nums[0]<nums[nums.length-1]) return nums[0];
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i]<nums[i-1]) return nums[i];
        }
        return nums[0];
    }

    //最稳妥的方式还是二分查找
    //0ms 100%
    //38.4mb 10.95%
    public int minAarrayBinarySearch(int[] nums){
        int low=0;
        int high=nums.length-1;
        while (low<high){
            int pivot = low+(high-low)/2;
            if(nums[pivot]<nums[high]) high=pivot;
            else if(nums[pivot]>nums[high]) low=pivot+1;
            else high--;
        }
        return nums[low];
    }
}
