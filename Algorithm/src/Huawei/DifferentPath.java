package Huawei;

/**
 * 描述
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 *
 * 备注：m和n小于等于100,并保证计算结果在int范围内
 *
 * 数据范围：0 < n,m <1000, 保证计算结果在32位整型范围内
 * 要求：空间复杂度 O(nm)，时间复杂度 O(nm)
 */
public class DifferentPath {
    public int uniquePaths (int m, int n) {
        // write code here
        int[][] dp = new int[m][n];
        for(int i=0; i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0; i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
