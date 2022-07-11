package leetcode.Stack;
import java.util.*;

/**
 * 给你一个整数数组nums和一个整数threshold。
 *
 * 找到长度为 k的nums子数组，满足数组中每个元素都 大于threshold / k。
 *
 * 请你返回满足要求的 任意子数组的 大小。如果没有这样的子数组，返回-1。
 *
 * 子数组 是数组中一段连续非空的元素序列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,3,1], threshold = 6
 * 输出：3
 * 解释：子数组 [3,4,3] 大小为 3 ，每个元素都大于 6 / 3 = 2 。
 * 注意这是唯一合法的子数组。
 *
 */
// 解题思路：使用单调栈
// 对于每个元素来说，假定它为子数组的最小值，并且为了让threshold/k尽可能小，k要足够大
// 则对于每个最小值，寻找它还小的值作为两边的边界.
// 使用栈来计算边界值：单调栈寻找边界用例: NextGreater I. 它找更大值，本题中是寻找更小值.
public class SubArrayWithElementsGreaterThanThreshold {
    public int validSubarraySize(int[] nums, int threshold) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        for(int i=0;i<n;i++){
            // 寻找更小值，如果栈内的数字不够小，把它弹出。
            while(!stack.isEmpty() && nums[i]<=nums[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]<=nums[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i =0;i<n;i++){
            int k = right[i]-left[i]-1;
            if((double)(nums[i]*k)>(double)threshold) return k;
        }
        return -1;
    }
}
