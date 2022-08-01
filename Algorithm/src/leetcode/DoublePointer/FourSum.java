package leetcode.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d< n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * 
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
public class FourSum {
    /**
     * Same solution of ThreeSun: Enum first two point a,b, then use double pointer c,d
     * as the smallest and the greatest element to adjust sum value.
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // -2 -1 0 0 1 2
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n<4){
            return res;
        }
        Arrays.sort(nums);
        for(int a=0; a<n-3; a++){
            if(a>0 && nums[a] == nums[a-1])
                continue;
            if(nums[a] + nums[a+1]> target - nums[a+2] - nums[a+3]) break;
            if ((long) nums[a] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for(int b= a+1; b<n-2; b++){
                if(b>1+a && nums[b]==nums[b-1])
                    continue;

                if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }

                if ((long) nums[a] + nums[b] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int c = b+1;
                int d = n-1;
                while(c<d){
                    if(nums[a] + nums[b] > target - nums[c] - nums[d]){
                        d--;
                    }
                    else if(nums[a] + nums[b] < target - nums[c] - nums[d]){
                        c++;
                    }
                    else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        c++;
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
