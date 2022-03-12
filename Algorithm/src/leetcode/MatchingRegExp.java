package leetcode;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 */
public class MatchingRegExp {
    public boolean isMatch(String s, String p){
        int m =s.length();
        int n =p.length();
        boolean[][] dp = new boolean [m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //*只有两种情况:1. 匹配 ss 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
                //2. 不匹配字符，将该组合扔掉，不再进行匹配。
                if(p.charAt(j-1)=='*'){
                    //如果浪费这个字符+*，没有匹配到，则直接j往前两个字符
                    dp[i][j] = dp[i][j-2];
                    //如果和s上一个匹配到了，则s进行回滚
                    if(match(i,s,j-1,p)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
                //正常字符匹配
                else{
                    if(match(i,s,j,p)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean match(int i, String s , int j , String p){
        if(i==0) return false;
        if(p.charAt(j-1)=='.') return true;
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
