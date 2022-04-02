package leetcode.Array;

import java.util.HashMap;

/**
 * 给定一个无序数组 arr , 其中元素可正、可负、可0。
 * 给定一个整数 k ，求 arr 所有连续子数组中累加和为k的最长连续子数组长度。保证至少存在一个合法的连续子数组。
 * [1,2,3]的连续子数组有[1,2]，[2,3]，[1,2,3] ，但是[1,3]不是
 * 要求：空间复杂度 O(n)， 时间复杂度 O(n)
 * 示例1
 * 输入：
 * [1,-2,1,1,1],0
 * 返回值：
 * 3
 */
public class SumKContinueSubArray {
    public int maxlenEqualK (int[] arr, int k) {
        // write code here
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            //从目前位置前缀和如果能减掉之前某个前缀和等于k，就找到了可以更新的位置
            // sum - (sum-k) == k，所以这里target注意不是k-sum，而是sum-k
            int target = sum-k;
            if(map.containsKey(target)){
                int len = i-map.get(target);
                max = Math.max(max,len);
            }
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}
