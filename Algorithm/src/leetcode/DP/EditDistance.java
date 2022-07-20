package leetcode.DP;

/**
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class EditDistance {
    // 编辑距离,很久没做之后差点忘记了。以前还用这个做过课题来着
    // 很经典的DP题目，题目告诉了动态转移方程式，照着写就行
    // DP定义的得是，在字符下标到i的word1和下标到j的word2中转换成一致所用的最小次数。
    // word1:horse      word2:ros
    // 如果i = 3, j = 3. dp[3][3] = 3.
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        // 下面这循环中定义的方式其实还可以改进一些
        // 写成 del = dp[i-1][j]+1,其他类似，最后dp[i][j]取三个中的最小值。可读性会好一些
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int del1 = dp[i + 1][j] + 1;
                    int del2 = dp[i][j + 1] + 1;
                    int replace = dp[i][j] + 1;
                    dp[i + 1][j + 1] = Math.min(del1, Math.min(del2, replace));
                }
            }
        }
//        dp[i][j-1] 为 A 的前 i 个字符和 B 的前 j - 1 个字符编辑距离的子问题。
//        即对于 B 的第 j 个字符，我们在 A 的末尾添加了一个相同的字符
//        那么 dp[i][j] 最小可以为 dp[i][j-1] + 1；
//        // 自底向上求解
//        int m = word1.length(), n = word2.length();
//        for (int i = 1; i <= m; i++)
//            for (int j = 1; j <= n; j++)
//                if (s1.charAt(i - 1) == s2.charAt(j - 1))
//                    dp[i][j] = dp[i - 1][j - 1];
//                else
//                    dp[i][j] = min(
//                            dp[i - 1][j] + 1,
//
//
//                            dp[i][j - 1] + 1,
//
//
//                            dp[i - 1][j - 1] + 1
//
//
//                    );
//        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[n][m];
    }

}
