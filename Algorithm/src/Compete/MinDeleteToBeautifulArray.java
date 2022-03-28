package Compete;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2216. 美化数组的最少删除数
 * 给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 *
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * 注意，空数组同样认为是美丽数组。
 *
 * 你可以从 nums 中删除任意数量的元素。
 * 当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 *
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,3,5]
 * 输出：1
 * 解释：可以删除 nums[0] 或 nums[1]
 * 这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至少需要删除 1 个元素。
 */
public class MinDeleteToBeautifulArray {
    public int minDeletion(int[] nums) {
        int cnt=0;//删除数
        // i -cnt表示删除后当前元素的index
        for (int i = 0; i < nums.length; i++) {
            if((i-cnt)%2==0&&i<nums.length-1&&nums[i]==nums[i+1]) {
                cnt++;
            }
        }
        if((nums.length-cnt)%2!=0) cnt++;//最后剩余长度为奇数，再删除一个
        return cnt;
    }
    //通过栈解决:
    public int minDeletionByStack(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        stack.push(nums[0]);
        for(int i =1; i<len; i++){
            if(stack.size()%2==0){
                stack.push(nums[i]);
            }
            else{
                if(stack.peek()==nums[i]){
                    continue;
                }
                else{
                    stack.push(nums[i]);
                }
            }
        }
        if(stack.size()%2==0) return len-stack.size();
        return len-stack.size()+1;
    }
}
