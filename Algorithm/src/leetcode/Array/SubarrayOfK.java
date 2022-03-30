package leetcode.Array;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数k ，请找到该数组中和为k的连续子数组的个数。
 *
 * 
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/QTMn0o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarrayOfK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            int target = sum - k;
            count+=map.getOrDefault(target,0);
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }
}
