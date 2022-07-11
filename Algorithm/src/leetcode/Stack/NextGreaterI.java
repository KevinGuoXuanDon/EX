package leetcode.Stack;

/**
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 *
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 */
import java.util.*;
public class NextGreaterI {
    // 从后往前遍历下一个更大的元素，如果更小就弹出
    // 用单调栈计算时的模板就是for循环里面套一个while,while所做的事情是：把不符合需求的数字弹出
    // 比如我们寻找更大值，如果栈内的值不够大，则把它弹出
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<= nums2[i]){
                stack.pop();
            }
            int higher = stack.isEmpty()? -1:stack.peek();
            map.put(nums2[i],higher);
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
