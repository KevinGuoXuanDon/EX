package Huawei;

/**
 * 一个机器人位于一个m x n网格的左上角
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *  [ 0, 0, 0]
 *  [ 0, 1, 0]
 *  [ 0, 0, 0]
 *  result = 2;
 *
 *  这是一个简单题，因为各个细节错误导致提交错误三次...
 *  提交一定要谨慎
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //处理初始位置情况
        if(obstacleGrid[0][0]==1){
            dp[0][0] = 0;
        }
        else{
            dp[0][0] = 1;
        }
        //处理两条边
        for(int i =1; i< m ; i++){
            if(obstacleGrid[i][0]==1) dp[i][0]=0;
            else if(obstacleGrid[i-1][0]!=1) dp[i][0]=dp[i-1][0];
        }
        //更简单的处理方式是
        // if(obstacleGrid[i][0]==1) break;
        // else dp[0][i]=1;
        for(int i =1; i< n ; i++){
            if(obstacleGrid[0][i]==1) dp[0][i]=0;
            else if(obstacleGrid[0][i-1]!=1) dp[0][i]=dp[0][i-1];
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
