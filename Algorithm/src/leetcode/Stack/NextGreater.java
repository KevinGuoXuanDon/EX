package leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），
 * 返回nums中每个元素的 下一个更大元素 。
 *
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *

 */
public class NextGreater {
    // 既然需要循环查找，就对数组长度取余
    // 栈用来存储下标，不为空时和下一个元素做比较
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index =0;
        int[] res = new int[nums.length];
        while(index<nums.length*2){
            while(!deque.isEmpty() && nums[deque.peek()]<nums[index%nums.length]){
                int i = deque.pop();
                res[i] = nums[index%nums.length];
            }
            deque.push(index%nums.length);
            index++;
        }
        int maxValue = Arrays.stream(nums).max().getAsInt();
        for(int i=0; i<res.length;i++){
            if(nums[i]==maxValue){
                res[i]=-1;
            }
        }
        return res;
    }
}
