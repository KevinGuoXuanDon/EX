package leetcode.Stimulate;

/**
 * @author xd_guo
 * @date 12/22/2022
 */
public class IsValidSudoku {
    /**
     * 数独的棋盘固定9*9，只需要判断已经存在的数字是否合法，空棋盘用 "."表示.
     * 可以用数组可以用Hash.
     * 每行、每列、每块都需要一个唯一性的数据结构来记录当前值，然后一次遍历就好了
     * 时间复杂度O(1)
     * 空间复杂度
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rowValid = new int[9][9];
        int[][] colValid = new int[9][9];
        int[][] block = new int[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int blockIndex = i/3 * 3 + j/3;
                    if(rowValid[i][num] == 1 || colValid[j][num]==1 || block[blockIndex][num]==1){
                        return false;
                    }
                    else{
                        rowValid[i][num] = 1;
                        colValid[j][num] = 1;
                        block[blockIndex][num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
