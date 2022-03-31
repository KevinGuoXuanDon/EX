package leetcode.TraceBack;

/**
 * 给定一个可能有重复数字的整数数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 * 
 *
 * 示例1:
 *
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
import java.util.*;
public class SumCombineWithRepeatElement {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traceBack(candidates,target,0,0);
        return res;
    }
    public void traceBack(int[] arr, int target, int index, int sum){
        if(sum>target) return;
        if(sum==target){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i=index; i<arr.length; i++){
            //这里过滤很重要，index的含义是：
            //[0, index) 区间是父节点们选过的区间，当前层不允许选择；
            //[index, length - 1] 区间是当前层所有可选的子节点；
            // 在当前节点中避免重复就可以了，如果是i>0 && arr[i]==arr[i-1]，就会在所有区间去重，导致结果[1,1,6]->[1,6]
            if(i>index && arr[i]==arr[i-1]) continue;
            sum+=arr[i];
            list.add(arr[i]);
            traceBack(arr,target,i+1,sum);
            sum-=arr[i];
            list.removeLast();
        }
    }
}
