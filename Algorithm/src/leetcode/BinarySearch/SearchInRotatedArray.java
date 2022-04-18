package leetcode.BinarySearch;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，
 * 如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class SearchInRotatedArray {
    //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0]==target? 0:-1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
