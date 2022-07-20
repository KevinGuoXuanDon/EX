package leetcode.DP;

/**
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if(n+m !=len)
            return false;
        /**
         * 这里dp的定义是,s1字符串下标到i和s2字符串下标到j的组合能够组成s3下标为i+j-1
         * 注意dp的长度为n+1,m+1。 因为要空出一个位置为0，用来表示当前还没有取s1或者s2.
         * 所以循环也是从0-n,0-m, 并且dp[i][j]的判断都和i-1,j-1有关
         */
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=0;i<=n;i++){
            for(int j=0; j<=m;j++){
                int pivot = i + j-1;
                if(i>0){
                    dp[i][j] =dp[i-1][j] && s3.charAt(pivot) == s1.charAt(i-1);
                }
                if(j>0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s3.charAt(pivot) == s2.charAt(j-1));
                }
            }
        }
        return dp[n][m];
    }
}
