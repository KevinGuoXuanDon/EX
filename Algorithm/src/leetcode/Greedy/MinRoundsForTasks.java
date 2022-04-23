package leetcode.Greedy;

import java.util.Arrays;

/**
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 *
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-rounds-to-complete-all-tasks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinRoundsForTasks {
    public int minimumRounds(int[] tasks) {
        if(tasks.length<=1) return -1;
        Arrays.sort(tasks);
        int ans =0;
        for(int i=0;i<tasks.length;i++){
            if(i==tasks.length-1 || tasks[i]!=tasks[i+1]) return -1;
            int flag = 1;
            while(i+1<tasks.length && tasks[i]==tasks[i+1]){
                flag++;
                i++;
            }
            if(flag%3!=0){
                ans += flag/3+1;
            }
            else{
                ans += flag/3;
            }
        }
        return ans;
    }
}
