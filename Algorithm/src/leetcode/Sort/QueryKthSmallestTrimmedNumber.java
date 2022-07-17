package leetcode.Sort;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一个下标从 0开始的字符串数组nums，其中每个字符串 长度相等且只包含数字。
 *
 * 再给你一个下标从 0开始的二维整数数组queries，
 * 其中queries[i] = [ki, trimi]。对于每个queries[i]，你需要：
 *
 * 将nums中每个数字 裁剪到剩下 最右边trimi个数位。
 * 在裁剪过后的数字中，找到 nums中第ki小数字对应的 下标
 * 。如果两个裁剪后数字一样大，那么下标 更小的数字视为更小的数字。
 * 将 nums中每个数字恢复到原本字符串。
 * 请你返回一个长度与 queries相等的数组answer，其中answer[i]是第i次查询的结果。
 *
 * 提示：
 *
 * 裁剪到剩下 x个数位的意思是不断删除最左边的数位，直到剩下 x个数位。
 * nums中的字符串可能会有前导 0 。
 *
 * 示例 1
 * 输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
 * 输出：[2,2,1,0]
 * 解释：
 * 1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
 * 2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
 * 3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
 * 4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
 *    注意，裁剪后数字 "02" 值为 2 。
 */
public class QueryKthSmallestTrimmedNumber {
    /**
     * 解题方法：直接模拟。因为要返回的是下标，需要自己定义排序方法和数据结构
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = nums[0].length();
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int k = queries[i][0];
            int trim = queries[i][1];
            Node[] temp = new Node[n];
            for(int j=0;j<n;j++){
                BigInteger value = new BigInteger(nums[j].substring(m-trim));
                temp[j] = new Node(j,value);
            }
            // 这里排序规则需要自己定义
            Arrays.sort(temp, (a, b) -> a.value.compareTo(b.value));
            res[i] = temp[k-1].index;
        }
        return res;
    }

    class Node{
        int index;
        BigInteger value;
        Node(int index, BigInteger value){
            this.index = index;
            this.value = value;
        }
    }
}
