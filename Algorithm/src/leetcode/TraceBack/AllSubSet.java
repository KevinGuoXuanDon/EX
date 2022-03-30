package leetcode.TraceBack;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/TVdhkn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllSubSet {
    //回溯法得出所有结论
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> cur = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recur(nums,0);
        return res;
    }
    public void recur(int[] nums, int i){
        res.add(new LinkedList<>(cur));
        for(int j = i; j<nums.length; j++){
            cur.add(nums[j]);
            recur(nums,j+1);
            cur.removeLast();
        }
    }
}
