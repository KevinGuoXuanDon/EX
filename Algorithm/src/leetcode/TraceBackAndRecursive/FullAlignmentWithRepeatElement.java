package leetcode.TraceBackAndRecursive;

/**
 * 给定一个可包含重复数字的整数集合nums ，按任意顺序 返回它所有不重复的全排列。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
import java.util.*;
public class FullAlignmentWithRepeatElement {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        traceBack(nums,0);
        return res;
    }
    public void traceBack(int[] nums, int index){
        if(index==nums.length){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i< nums.length; i++){
            if(visited[i] || (i!=0 && nums[i]==nums[i-1] && !visited[i-1])) continue;
            list.add(nums[i]);
            visited[i] = true;
            traceBack(nums,index+1);
            list.removeLast();
            visited[i]= false;
        }
    }
}
