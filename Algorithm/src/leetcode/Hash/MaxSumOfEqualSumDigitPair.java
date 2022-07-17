package leetcode.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。
 * 请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与 nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 */
public class MaxSumOfEqualSumDigitPair {
    public int maxSum(int[] nums) {
        // map 加一次遍历
        Map<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for(int i : nums){
            int sod = 0;
            int temp =i;
            while(temp!=0){
                sod += temp % 10;
                temp /= 10;
            }
            if(map.containsKey(sod)){
                max = Math.max(max, i+map.get(sod));
                if(i>map.get(sod)) {
                    map.put(sod, i);
                }
            }
            else{
                map.put(sod,i);
            }
        }
        return max;
    }
}
