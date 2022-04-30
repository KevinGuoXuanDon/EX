package leetcode.DP;

import java.util.HashMap;

public class SuperEggDrop {
    /**
     * 二分+动态规划的思想
     * 当我们从第 xx 楼扔鸡蛋的时候：
     *
     * 如果鸡蛋不碎，那么状态变成 (k,n−x)，即我们鸡蛋的数目不变，
     * 但答案只可能在上方的 n−x 层楼了。也就是说，我们把原问题缩小成了一个规模为 (k, n-x)的子问题；
     *
     * 如果鸡蛋碎了，那么状态变成 (k−1,x−1)，即我们少了一个鸡蛋，
     * 但我们知道答案只可能在第 x 楼下方的 x-1 层楼中了。也就是说，我们把原问题缩小成了一个规模为k−1,x−1) 的子问题。
     *
     * 这样一来，我们定义 dp(k,n) 为在状态 (k, n)下最少需要的步数。根据以上分析我们可以列出状态转移方程：
        ans = 1 + Math.max(dp(k - 1, x - 1), dp(k, n - x));
     */
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }
    public int dp(int k, int n) {
        if (!map.containsKey(100 * n + k)) {
            int ans = 0;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int low = 1;
                int high = n;
                while (low + 1 < high) {
                    int mid = low + (high - low) / 2;
                    int f1 = dp(k - 1, mid - 1); //鸡蛋碎了，往下找
                    int f2 = dp(k, n - mid);   //鸡蛋没碎，往上找，层数为总层数-没碎的层数
                    if (f2 > f1) { // 哪一种情况产生的dp更大，就遍历哪一种
                        low = mid;
                    } else if (f1 > f2) {
                        high = mid;
                    } else {
                        low = high = mid;
                    }
                }
                ans = 1 + Math.max(dp(k - 1, high - 1), dp(k, n - high));
            }
            map.put(100 * n + k, ans);
        }
        return map.get(100 * n + k);
    }
}