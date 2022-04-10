package leetcode.Array;

/**
 * 爱丽丝和鲍勃拥有不同总数量的糖果。
 * 给你两个数组 aliceSizes 和 bobSizes
 * aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 *
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
 *
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。
 * 如果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 * 示例 1：
 *
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 */
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
public class SwapCandy {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        Set<Integer> set = new HashSet<>();
        for(int i:bobSizes){
            set.add(i);
        }
        int gap = bobSum-aliceSum;
        for(int i: aliceSizes){
            int target = (gap+ 2*i)/2;
            if(set.contains(target)) return new int[]{i,target};
        }
        return new int[0];
    }
}
