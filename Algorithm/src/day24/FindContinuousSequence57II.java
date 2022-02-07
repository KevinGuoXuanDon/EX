package day24;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]

 */
public class FindContinuousSequence57II {
    //滑动窗口（双指针解决），时间复杂度O(n)
    //2ms 96.59%
    public int[][] findContinueSequence(int target){
        List<int[]> list = new ArrayList<>();
        int l=1,r=2, sum=l+r;
        while(l<r){
            if(sum==target){
                int[] temp = new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    temp[i-l]= i;
                }
                list.add(temp);
            }
            if(sum>=target){
                sum-=l;
                l++;
            }
            if(sum<target){
                r++;
                sum+=r;
            }
        }
        return list.toArray(new int[0][]);
    }
}
