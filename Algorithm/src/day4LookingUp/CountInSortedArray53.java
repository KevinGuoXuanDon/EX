package day4LookingUp;

import java.util.HashMap;

/**
 * 统计一个数字在升序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,8,10], target = 7
 * 输出: 2
 */
public class CountInSortedArray53 {
    //二分查找左右边界
    //0ms 100%
    public int CountInSortedArray53(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums.length <= 0)
            return 0;
        // 查找右边界:
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            // 目的：如果target存在，那么让i成为第一个大于target的数的下标
            // 或者，让j成为最后一个不大于target的数的下标
            // 当退出while时,j+1=i
            int m = (i + j) / 2;
            if (nums[m] <= target)
                i = m + 1;
            else
                j = m - 1;
        }
        int r = j;
        if (j < 0 || nums[j] != target)
            // target不存在 . 注意： j < 0
            return 0;

        // 查找左边界
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            // 目的：如果target存在，那么让j成为第一个小于target的数的下标，
            // 或者，让i成为第一个不小于target的数的下标。
            // 当退出while时,j+1=i
            int m = (i + j) / 2;
            if (nums[m] >= target)
                j = m - 1;
            else
                i = m + 1;
        }
        int l = i;
        //
        return r - l + 1;
    }
    //Hashmap
    //10ms 5.10%
    public int CountInSortedArray532(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        if(map.containsKey(target)) return map.get(target);
        else return 0;
    }
}