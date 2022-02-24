package MicroSoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /**
     * O(n^2) 19ms 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumByDoublePointer(int[] nums){
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            if(nums[first]>0) return result;
            if(first>0 && nums[first] == nums[first-1]) continue;
            int left = first+1;
            int right= length-1;
            while(left<right){
                int sum = nums[first]+nums[left]+nums[right];
                if(sum>0) right--;
                else if(sum<0) left++;
                else{
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[first]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * O(n^2) 21ms 双重循环+指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int third = nums.length - 1;
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && (nums[first] + nums[second] + nums[third] > 0)) {
                    third--;
                }
                if (second == third) break;
                if (nums[first] + nums[second] + nums[third] == 0) {
                    LinkedList<Integer> temp = new LinkedList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
