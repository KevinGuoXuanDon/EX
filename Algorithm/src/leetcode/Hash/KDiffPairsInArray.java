package leetcode.Hash;

/**
 * 给你一个整数数组nums 和一个整数k，请你在数组中找出 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 */
import java.util.*;
public class KDiffPairsInArray {
    // 用两个HashSet记录。一个记录需要的目标值，一个记录结果的数据对. 时间复杂度为O(n)
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        // 如果用String类型存储数对,时间要从8ms->18ms. res.add(i+" "+ (i-k));
        HashSet<Integer> res = new HashSet<>();
        for(int i : nums){
            if(set.contains(i-k)){
                res.add((i-k));
            }
            if(set.contains(i+k)){
                res.add((i));
            }
            set.add(i);
        }
        return res.size();
    }
    // 也可以用排序+滑动窗口 4ms,时间复杂度o(nlogn),按理说时间复杂度要更高
    public int findPairsByDoublePointer(int[] nums, int k){
        Arrays.sort(nums);
        int left =0, right = 0;
        int count = 0;
        for(;right<nums.length;right++){
            if(right+1<nums.length && nums[right]== nums[right+1]) {
                continue;
            }
            while(left<right  && nums[right]- nums[left]>k){
                left++;
            }
            if(left<right && nums[right] - nums[left]==k){
                count++;
            }
        }
        return count;
    }
}
