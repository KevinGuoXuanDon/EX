package leetcode.BinarySearch;

import java.util.HashSet;

/**
 * 给定一个包含n + 1 个整数的数组nums ，
 * 其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 */
public class FindTheDuplicateNumber {
    /**
     * 这是一个挺怪的题目，可以认为是用时间换取空间，而解决方式这里用了二分查找。
     * 二分查找需要一个有序的单调数组，而题设中的数组明显不符合。
     * 所以这里用的其实是一个潜在的下标数组：
     * 由于一直至少存在一个重复数字，对于1 - n-1中至少有一个重复。
     * 那么如果这么思考： 以数组 [1,3,4,2,2]为例子
     * 对于数字1， 小于等于它的有 1 个
     * 对于数字2， 小于等于它的本该有2个(1,2)，目前有三个(1,2,2)
     * 对于数字3， 小于等于它的本该是3个(1,2,3)，目前有4个(1,2,2,3)
     * 以此类推，可以看到随着判定数字变大，小于等于它的数字也单调递增,
     * 而判断是否存在重复则是看它的计数是否大于等于数字本身
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums){
        int n = nums.length;
        int left = 1, right = n-1;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            int count = 0;
            for(int i:nums){
                if(i<=mid){
                    count++;
                }
            }
            if(count<=mid){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        /**
         * 也可以写成 while(left<right), else里写成 right = mid, 最后返回 right.
         */
        return mid;
    }

    /**
     * A Hash solution will take O(n) time complexity
     * @param nums
     * @return
     */
    public int findDuplicateByHash(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }

}
