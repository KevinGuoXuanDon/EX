package leetcode;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class UglyNumber {
    /**
     当索引 a, b, ca,b,c 满足以下条件时， dp[i]dp[i] 为三种情况的最小值；
     每轮计算 dp[i]dp[i] 后，需要更新索引 a, b, ca,b,c 的值，使其始终满足方程条件。
     实现方法：分别独立判断 dp[i] 和dp[a]×2 , dp[b]×3 , dp[c]×5 的大小关系
     若相等则将对应索引 a , b , c 加 1 ；
     dp[a]×2>dp[i−1]≥dp[a−1]×2
     dp[b]×3>dp[i−1]≥dp[b−1]×3
     dp[c]×5>dp[i−1]≥dp[c−1]×5
     dp取他们最小值
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2, nb = dp[b] * 3, nc = dp[c] * 5;
            dp[i] = Math.min(na, Math.min(nb, nc));
            if (dp[i] == na) a++;
            if (dp[i] == nb) b++;
            if (dp[i] == nc) c++;
        }
        return dp[n - 1];
    }
}
