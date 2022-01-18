package day13DoublePointer;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]

 */
public class TwoSum57 {
    //2ms, 78.62%
    //55.1MB 86.22%
    //BinarySearch
    public int[] twoSum(int[] nums, int target) {
        int l=0,r= nums.length-1;
        while(l<r){
            int sum = nums[l]+nums[r];
            if(target==sum) return new int[]{nums[l],nums[r]};
            else if(target<sum) r--;
            else l++;
        }
        return null;
    }
}
