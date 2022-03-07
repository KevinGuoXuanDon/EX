package Compete;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/append-k-integers-with-minimal-sum/
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 *
 * 返回追加到 nums 中的 k 个整数之和。
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 *
 * 方法：贪心+数学，见缝插针。不能hashset+直接线性遍历因为k最大1e9,时间复杂度直逼平方级别
 * 每一段每一段的插入连续的数字。
 * 数组排序后:
 * 从0插到nums[0]，从nums[0]到nums[1]....nums[length-1]到nums[length-1]+k
 * 利用等差数列求和公式。
 */
public class AddKToArray6017 {
    public long minimalKSum(int[] nums, int k) {
       Arrays.sort(nums);
       long result=0;
       long start = 0;
       for (int i = 0; i < nums.length; i++) {
            if(start<nums[i]){
                long countLength = nums[i]-start>k ? k:nums[i]-start;
                //前n项和公式为：Sn=n*a1+n(n-1)d/2或Sn=n(a1+an)/2 。
                result += countLength * (start+ (start+countLength-1))/2;
                k-=countLength;
            }
            start +=nums[i];
       }
        //如果此时k中还有数，start已经在数组最大元素处了，此时长度为k，初始值start
        if(k>0){
            result += k *(start + start+k-1)/2;
        }
        return result;
    }
}
