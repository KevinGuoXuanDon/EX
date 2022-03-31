package leetcode.TraceBack;

/**
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
import java.util.*;
public class FullAlignment {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        traceBack(nums,0);
        return res;
    }
    public void traceBack(int[] nums, int index){
        if(index==nums.length){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i=0;i<nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            traceBack(nums,index+1);
            list.removeLast();
        }
    }
}
