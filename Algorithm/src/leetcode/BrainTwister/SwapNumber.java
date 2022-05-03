package leetcode.BrainTwister;

/**
 * 面试题 16.01. Swap Numbers LCCI
 * Write a function to swap a number in place (that is, without temporary variables).
 *
 * Example:
 *
 * Input: numbers = [1,2]
 * Output: [2,1]
 */
public class SwapNumber {
    // 最好还是用位运算，以下在特殊情况下会溢出 如 [1,2147483647]
    public int[] swapNumber(int[] arr){
        arr[0] = arr[0] = arr[1];
        arr[1] = arr[0] - arr[1];
        arr[0] = arr[0] - arr[1];
        return arr;
    }
}
