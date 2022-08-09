package leetcode.BinarySearch;

/**
 * 值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 */
public class FindPeakElement {
    /**
     * 类似于随即爬山法，但是这里不需要随机，取中点判断就好
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) /2 ;
            if(compare(mid,mid+1,nums) && compare(mid,mid-1,nums))
                return mid;
            if (compare(mid,mid+1,nums)) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public int amendGet(int index, int[] nums) {
        if (index == -1 || index == nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }

    public boolean compare(int index1, int index2, int[] nums) {
        int value1 = amendGet(index1, nums);
        int value2 = amendGet(index2, nums);
        return value1 > value2;
    }
}
