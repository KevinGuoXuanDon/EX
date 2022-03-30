package leetcode.TraceBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 * 
 *
 * 示例1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Ygoe9J
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllowRepeatCombine {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traceBack(0,0,candidates,target);
        return res;
    }
    public void traceBack(int index, int sum, int[] arr, int target){
        if(sum>target){
            return;
        }
        else if(sum == target){
            res.add(new LinkedList<>(list));
        }
        // 这里注意，调用的不是向之前两个一样返回的index+1,
        // 而是在这里返回了i，否则会发生重复，比如出现2,2,3和2,3,2，还有3,2,2这种情况
        for(int i = index; i<arr.length; i++){
            list.add(arr[i]);
            sum+=arr[i];
            traceBack(i,sum,arr,target);
            sum-=arr[i];
            list.removeLast();
        }
    }
    // 提供一种不使用for循环的思路.
    void dfs(int i,int[] nums,List<Integer> list2,int target){
        if(target<0||i==nums.length) return;
        if(target==0){
            res.add(new ArrayList<>(list2));
            return;
        }
        list2.add(nums[i]);
        //直接再次选用这个元素
        dfs(i,nums,list2,target-nums[i]);
        list2.remove(list2.size()-1);
        //或者跳过，选择下一个元素
        dfs(i+1,nums,list2,target);
    }

}
