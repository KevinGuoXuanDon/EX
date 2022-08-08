package leetcode.Stack;

/**
 * 函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，
 * 调用其他函数花费的时间不算该函数的独占时间。
 * 例如，如果一个函数被调用两次，一次调用执行 2 单位时间，
 * 另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
 *
 * 以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
 *
 * 示例 1：
 *
 * 输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * 输出：[3,4]
 * 解释：
 * 函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，于时间戳 1 的末尾结束执行。 
 * 函数 1 在时间戳 2 的起始开始执行，执行 4 个单位时间，于时间戳 5 的末尾结束执行。 
 * 函数 0 在时间戳 6 的开始恢复执行，执行 1 个单位时间。 
 * 所以函数 0 总共执行 2 + 1 = 3 个单位时间，函数 1 总共执行 4 个单位时间。 
 *
 */
import java.util.*;
public class ExclusiveTimeOfFunctions {
    /** Use stack to stimulate situation
        Once a nested function finished, check weather the outside function exist.
        if true, outside function time should minus the inside time.
    */
    public int[] exclusiveTime(int n, List<String> logs){
        Deque<int []> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for(String s:logs){
            String[] strs = s.split(":");
            int mark = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if("start".equals(strs[1])){
                stack.push(new int[]{mark, time});
            }
            else{
                int[] last = stack.pop();
                int timeGap = time - last[1] +1;
                int id = last[0];
                res[id] += timeGap;
                if(!stack.isEmpty()){
                    res[stack.peek()[0]] -= timeGap;
                }
            }
        }
        return res;
    }
}
