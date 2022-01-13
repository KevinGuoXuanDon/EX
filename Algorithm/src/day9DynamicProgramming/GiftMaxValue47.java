package day9DynamicProgramming;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

 */
public class GiftMaxValue47 {
    //2ms, 98.52%
    //和之前一样，假设现在走到了某个位置，当前位置的礼物肯定是要选的，那么需要推是从上方走下来还是左方
    //从上方时，上方的最大礼物价值为f(i-1,j)，左方礼物最大价值为f(i,j-1)，则当前礼物价值为grid(i,j)加上较大值.
    //状态转移方程: f(i,j) = max[f(i-1,j),f(i,j-1)] + grid(i,j)
     /*       Grid          dp
            [1,3,1],    [1, 4, 5],
            [1,5,1],    [2, 9, 10],
            [4,2,1]     [6, 11,12]

      */
    public int maxValue(int[][] grid){
        int row = grid.length;
        if(row==0) return 0;
        int column = grid[0].length;
        int[][] dp = new int[row][column];//dp表示走到当前位置时礼物的最大价值
        dp[0][0]=grid[0][0];
        //两个for循环对dp的两条边初始化
        for (int i = 1; i <row; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = grid[i][j]+ Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row][column];
    }
}
