package leetcode.TraceBack;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 将得到一个整数数组 matchsticks ，
 * 其中 matchsticks[i] 是第 i个火柴棒的长度。
 * 你要用 所有的火柴棍拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 * 
 *
 * 示例1:
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 */
public class MatchSticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum= Arrays.stream(matchsticks).sum();
        if(matchsticks.length<4 || sum%4!=0) return false;
        int[] bucket = new int[4];
        Arrays.sort(matchsticks);
        //转化为降序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return recur(matchsticks,0, sum/4,bucket);

    }
    public boolean recur(int[] sticks, int index, int target, int[] sum ){
        if(index == sticks.length) return true;
        for(int i =0; i<4; i++){
            if(sum[i] + sticks[index] > target) continue;
            // 下面一行剪枝让代码运行时间从106ms -> 5ms
            // 对回溯尝试进行剪枝操作，若上一条边没有成功，则当前边一定不会成功
            if(i>0 && sum[i-1] == sum[i]) continue;

            sum[i] +=sticks[index];
            if(recur(sticks,index+1,target,sum)){
                return true;
            }
            sum[i] -= sticks[index];
        }
        return false;
    }
}
