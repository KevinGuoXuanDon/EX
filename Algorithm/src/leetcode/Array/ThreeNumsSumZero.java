package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组.
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 */
public class ThreeNumsSumZero {
    //确定好一个数字后，使用双指针来找是否存在其他两个数字是的相加为0.
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while(left<right){
                if(nums[left]+nums[right]==target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //下面这个去重 ++left和--right很关键，否则就需要使用set去重了。
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
                else if(nums[left]+nums[right]>target){
                    right--;
                }
                else{
                    left++;
                }

            }
        }
        return res;
    }
}
