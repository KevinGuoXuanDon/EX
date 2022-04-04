package leetcode.DP;

/**
 * 如果一个由'0' 和 '1'组成的字符串
 * 是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1'组成的字符串 s，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
 *
 * 返回使 s单调递增的最小翻转次数。
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 */
public class MonotonicallyIncreasingString {
    //思路是，dp[i][0]代表第i个位置保持字符为0的递增字符串最小的反转次数。
    //dp[i][1]则保持i位置的字符为'1'
    public int minFlipsMonoIncr(String s) {
        if(s.length()<=1) return 0;
        int[][] dp = new int[s.length()][2];
        if(s.charAt(0)=='0') {
            //如果本来就是0，保持为0就不用反转，保持为1则反转一次
            dp[0][0]=0;
            dp[0][1]=1;
        }else{
            dp[0][0]=1;
            dp[0][1]=0;
        }
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='0'){
                //如果要保持当前字符为0，前一个字符只能为0，所以反转次数保持相同
                dp[i][0] = dp[i-1][0];
                //如果保持当前字符为1，前一个字符可以为0或者1，当前字符从0-》1反转次数+1
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0])+1;
            }
            else{
                //同上
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]);
                dp[i][0] = dp[i-1][0]+1;
            }
        }
        //最后一个字符为0或者1时，返回最小反转次数
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }
}
