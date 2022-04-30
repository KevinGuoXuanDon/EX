package leetcode.Array;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestContinueSubsequence {
    public int longestConsecutive(int[] nums) {
        // 时间复杂度为n，空间复杂度为n
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int res = 0;
        for(int i:set){
            if(!set.contains(i-1)){
                int count = 1;
                // 不修改原数组
                int num = i;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
        // 时间复杂度为nlogn,空间复杂度为1
        /*
        int n = nums.length;
        if(n<=1) return n;
        Arrays.sort(nums);
        int len = 0;
        for(int i =0;i<n-1;i++){
            int count = 1;
            while(i<n-1 && nums[i+1] == nums[i]+1){
                count++;
                i++;
                while(i<n-1 && nums[i]==nums[i+1]) i++;
            }
            len = Math.max(len,count);
        }
        return len;
        */
    }
}
