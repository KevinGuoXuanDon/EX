package leetcode.DP;

/**
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 */
public class FlipStringToIncreasing {
    // 动态规划，预设当前位置的数字和实际数字对比
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0)=='0'? 0:1;
        dp[0][1] = s.charAt(0)=='1'? 0:1;
        for(int i =1; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur=='0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+1;
            }
            else{
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }
}
