package leetcode.DP;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length<=1) return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
        int[][] dp = new int[costs.length][3];
        for(int i=0;i<3;i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i<costs.length; i++){
            for(int j=0;j<3;j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+costs[i][j];
            }
        }
        return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }
}
