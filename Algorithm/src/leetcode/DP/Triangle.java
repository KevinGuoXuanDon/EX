package leetcode.DP;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。

 */
public class Triangle {
    /**
     * 说实话感觉这道题目用DFS搜索完全能够解决，当前层的递推完全取决于上一层相邻元素
     * 感觉没有解决很多重叠子问题
     * 时间空间复杂度平方级别
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m =triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for(int i =1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j=1; j<triangle.get(i).size();j++){
                if(j!=triangle.get(i).size()-1)
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                else
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
            }

        }
        for(int i=0;i<m; i++){
            min = Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}
