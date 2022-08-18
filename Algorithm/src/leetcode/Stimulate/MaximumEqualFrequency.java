package leetcode.Stimulate;

import java.util.HashMap;

/**
 * 给你一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 *
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 */
public class MaximumEqualFrequency {
    /**
     * 一次正向遍历，对于每个新元素添加进来后，判断它和之前的元素是否能够组成题设要求的形式
     * 1. 最大频率为1，删除任何一个元素都可以
     * 2. 所有元素都是最大频率，还有1个元素只有1个，也满足
     * 3. 1个元素是最大频率，其他的都是max-1
     *
     * 判断这三种条件则需要数据结构帮助，可以使用两个hash
     * map用作储存每个元素出现次数
     * count用作储存每个频率有多少种元素
     * [2,2,1,1,5]
     * map -> [1,2],[2,2],[5,1]
     * count -> [2,2],[1,5] 频率为2的元素有1，2， 频率为1的元素为5
     * @param nums
     * @return
     */
    public int maxEqualFreq(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        int res = 0, max = 0;
        for(int i=0; i<nums.length; i++){
            int value = nums[i];
            if(map.getOrDefault(value,0)>0){
                count.put(map.get(value),count.get(map.get(value))-1);
            }
            map.put(value, map.getOrDefault(value,0)+1);
            max = Math.max(max,map.get(value));
            count.put(map.get(value),count.getOrDefault(map.get(value),0)+1);
            boolean flag = max ==1
                    || (max* count.get(max) +1) == i+1
                    ||  1+(count.get(max-1)+1) * (max-1) == i+1;
            if(flag){
                res = Math.max(res,i+1);
            }
        }
        return res;
    }
}
