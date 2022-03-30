package leetcode.Array;

import java.util.HashMap;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class ZeroAndOneArray {
    //使用的方法也是前缀和+hashmap。
    //用把1转换成0方便计算，用hashmap去记录下每个位置的和，同时向后遍历。
    //如果遍历时发现当前和在hashmap中已经有了，说明从当前位置到map存储的下标和为0，如果没有则添加进入map.
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int max=0;
        for(int i =0; i<nums.length; i++){
            if(nums[i]==1){
                sum+=1;
            }
            else{
                sum-=1;
            }
            if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
