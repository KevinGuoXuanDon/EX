package day14SearchAndBacktracking;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */


public class RobotMovingRange13 {
    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return recur(flag,0,0,k);
    }

    public int recur(int[][] flag, int i, int j, int k){
        int m = flag.length;
        int n = flag[0].length;
        if(i<0||i>m-1 || j<0 || j>n-1|| getSum(i,j)>k || flag[i][j]==1) return 0;
        flag[i][j]=1;
        // 下面写法是1ms 60.74%
        // return 1+recur(flag, i+1, j, k)+recur(flag, i-1, j, k)+recur(flag, i, j+1, k)+recur(flag, i, j-1, k);
        // 0ms 100%. 隐藏优化，只需要向右和下找，因为一旦某一个在之前return了，之后这个方向的都会大于K
        return 1+recur(flag, i+1, j, k)+recur(flag, i, j+1, k);
    }
    public int getSum(int i, int j){
        int result=0;
        while(i!=0){
            result+=i%10;
            i/=10;
        }
        while(j!=0){
            result+=j%10;
            j/=10;
        }
        return result;
    }
}
