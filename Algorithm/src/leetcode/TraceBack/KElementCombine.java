package leetcode.TraceBack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 
 *
 * 示例 1:
 *
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uUsW3B
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;
public class KElementCombine {
    //直接回溯
    List<List<Integer>> res;
    LinkedList<Integer> curList;
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        curList = new LinkedList<>();
        traceBack(1,n,k);
        return res;
    }
    public void traceBack(int index, int n, int k){
        if(curList.size()==k){
            res.add(new LinkedList<>(curList));
        }
        for(int i = index; i<=n;i++){
            curList.add(i);
            traceBack(i+1,n,k);
            curList.removeLast();
        }
    }
}
