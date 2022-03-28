package Compete;

/**
 * 给你一个下标从 0开始的字符串text和另一个下标从 0开始且长度为 2的字符串pattern，两者都只包含小写英文字母。
 *
 * 你可以在 text中任意位置插入 一个 字符，这个插入的字符必须是pattern[0]或者pattern[1]。注意，这个字符可以插入在 text开头或者结尾的位置。
 *
 * 请你返回插入一个字符后，text中最多包含多少个等于 pattern的 子序列。
 *
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 */
public class MaximizeNumberOfSubsequences {
    //竞赛的时候还用dp，平方级别算法超时了，不应该弄的这么麻烦，直接贪心算法就好了
    //因为pattern只有两个字符，最好的插入情况就是第一个字符插在首位，第二个字符插在末尾，这样最容易找到字串
    //在开始处添加'a'，则子序列数量=初始子序列数量+'c'的数量。
    //在结尾处添加'c'，则子序列数量=初始子序列数量+'a'的数量。
    public long  maximumSubsequenceCountByGreedy(String text, String pattern) {
        char first = pattern.charAt(0);
        char second = pattern.charAt(1);
        //踩的另一个坑：一定不要把long写成了int
        long cntSecond=0;
        long cntFirst=0;
        long initialSubsequence = 0;
        for(int i=text.length()-1; i>=0; i--){
            char cur = text.charAt(i);
            //注意下面两个if不能写反了
            //每次找到头，都可以看后面有几个尾已经找到，那么就有几个子序列
            if(cur==first){
                cntFirst++;
                initialSubsequence += cntSecond;
            }
            if(cur==second){
                cntSecond++;
            }

        }
        return initialSubsequence + Math.max(cntFirst,cntSecond);
    }
    public long maximumSubsequenceCount(String text, String pattern) {
        long max =0;
        for (int i = 0; i < text.length(); i++) {
            StringBuilder sb = new StringBuilder(text);
            sb.insert(i,pattern.charAt(0));
            max = Math.max(max,numDistinct(sb.toString(),pattern));
            sb.replace(i,i, String.valueOf(pattern.charAt(1)));
            max = Math.max(max,numDistinct(sb.toString(),pattern));
        }
        return max;
    }
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
