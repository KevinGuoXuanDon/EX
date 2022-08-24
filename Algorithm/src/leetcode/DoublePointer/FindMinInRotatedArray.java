package leetcode.DoublePointer;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 */
public class FindMinInRotatedArray {
    /**
     * 题目提示的很明显是要二分查找，而二分查找需要找到做判断的规律，一般来说是有序数组
     * 这个旋转过的数组也是可以实现的，只要发现一下情况:
     * 1. 如果值left < mid < right，说明这一块是有序的，直接返回num[left]
     * 2. 如果 值mid>left, mid > right, 说明当前节点最高，直接往右查找
     * 3. 如果 值mid<left, mid < right, 当前节点最低，往左查找
     */
    public int findMin(int[] nums){
        int left=0, right= nums.length-1;
        while(left<right){
            int mid = left + (right - left) /2;
            // 如果已经遍历到了只剩两个元素
            if(right == left +1){
                return Math.min(nums[left],nums[right]);
            }
            if(nums[mid] > nums[left] && nums[mid]>nums[right]){
                left = mid;
            }
            else  if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                right = mid;
            }
            else{
                return nums[left];
            }
        }
        // 只有nums.length = 1 的时候会触发这里
        return nums[0];
    }
}
