package leetcode.Stimulate;

import java.util.Arrays;

/**
 * 给你两个正整数数组nums 和numsDivide。你可以从nums中删除任意数目的元素。
 *
 * 请你返回使 nums中 最小元素可以整除 numsDivide中所有元素的 最少删除次数。
 * 如果无法得到这样的元素，返回 -1。
 *
 * 如果y % x == 0，那么我们说整数x整除y。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
 * 输出：2
 * 解释：
 * [2,3,2,4,3] 中最小元素是 2 ，它无法整除 numsDivide 中所有元素。
 * 我们从 nums 中删除 2 个大小为 2 的元素，得到 nums = [3,4,3] 。
 * [3,4,3] 中最小元素为 3 ，它可以整除 numsDivide 中所有元素。
 * 可以证明 2 是最少删除次数。
 */
public class MinimumDeletionsToMakeArrayDivisible {

    //简单模拟，如果当前元素不能被整除，换下一个. 9ms 100%
    public int minOperationsByStimulation(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = numsDivide.length;
        int res = 0;
        int i =0;
        while(i<n){
            int count = 0;
            for(int j:numsDivide){
                if(j%nums[i]==0){
                    count++;
                }
                else break;
            }
            if(count==m){
                return res;
            }
            while(i+1<n && nums[i]==nums[i+1]) {
                i++;
                res++;
            }
            i++;
            res++;
        }
        return -1;
    }


    //通过求最大公因数，来计算当前这个元素是否为最大公因数的因子，进而判断.
    // 10ms 100%
    public int minOperations(int[] nums, int[] numsDivide) {
        var g = 0;
        for (var x : numsDivide) g = gcd(g, x);
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) if (g % nums[i] == 0) return i;
        return -1;
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
