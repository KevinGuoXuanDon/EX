package Compete;

import java.util.Arrays;

/**
 * 给你一个下标从 0开始的整数数组nums，它表示一个 栈 ，其中 nums[0]是栈顶的元素。
 *
 * 每一次操作中，你可以执行以下操作 之一：
 *
 * 如果栈非空，那么 删除栈顶端的元素。
 * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加回栈顶，这个元素成为新的栈顶元素。
 * 同时给你一个整数k，它表示你总共需要执行操作的次数。
 *
 * 请你返回 恰好执行 k次操作以后，栈顶元素的 最大值。如果执行完 k次操作以后，栈一定为空，请你返回 -1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,2,4,0,6], k = 4
 * 输出：5
 * 解释：
 * 4 次操作后，栈顶元素为 5 的方法之一为：
 * - 第 1 次操作：删除栈顶元素 5 ，栈变为 [2,2,4,0,6] 。
 * - 第 2 次操作：删除栈顶元素 2 ，栈变为 [2,4,0,6] 。
 * - 第 3 次操作：删除栈顶元素 2 ，栈变为 [4,0,6] 。
 * - 第 4 次操作：将 5 添加回栈顶，栈变为 [5,4,0,6] 。
 */

public class MaximizeTheTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        if(nums.length==1) return k%2==1? -1: nums[0];
        // 当k大于数组长度时，可以取到最大值。但是不用stream流式计算1ms，用了反而6ms？？？
        //if(k>nums.length) return Arrays.stream(nums).max().getAsInt();
        int max = 0;
        for(int i=0; i< nums.length && i<k-1; i++){
            max = Math.max(nums[i],max);
        }
        if(k<nums.length) max = Math.max(max,nums[k]);
        return max;
    }
}
