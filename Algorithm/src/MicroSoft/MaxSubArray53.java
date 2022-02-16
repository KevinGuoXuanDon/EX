package MicroSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 求最大连续自数组的和
 * 比如-2,1,-3,4,-1,2,1,-5,4
 * result=4 -1 +2 +1 = 6
 * 顺便打印路径
 * 解决方法：遍历到第i个数字时，通过比较这个数字和当前sum来决定下一步策略 dp[i] = max(dp[i-1]+i,i)
 */
public class MaxSubArray53 {
    int[] result;
    public int maxSubAarray(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int pre = 0, max = nums[0];
        for (int i : nums) {
            if(i>=pre+i){
                pre=i;
                arrayList.removeAll(arrayList);
                arrayList.add(i);
            }
            else{
                pre=pre+i;
                arrayList.add(i);
            }
            if(pre>=max){
                max=pre;
                System.out.println();
                result=arrayList.stream().mapToInt(Integer::valueOf).toArray();
            }
        }
        Arrays.stream(result).forEach(System.out::println);
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray53 maxSubArray53 = new MaxSubArray53();
        maxSubArray53.maxSubAarray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
