package leetcode.BFSDFS;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 Input: board = [["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]]

 */
public class Sudoku {
    public void solve(char[][] borad){

    }
    // 注意这里的函数签名用的是boolean，因为我们只想要找到一种解，比如八皇后问题, 而非全部解（比如排列组合问题）
    public boolean backTrace(char[][] board, int x, int y){
        // 思路：按照行一个一个位置进行填充，本行填满了就进行下一行填充
        if(y==9){
            return backTrace(board,x+1,y);
        }
        // 如果每一行都填满了，则找到了正确解，直接返回
        if(x==9){
            return true;
        }
        // 如果当前位置已经填了数字，不需要我们填，直接去下一个位置
        if(board[x][y]!='.'){
            return backTrace(board,x,y+1);
        }
        // 非上述情况，说明需要对当前位置进行填充
        for(char c = '1'; c<='9'; c++){
            // 判断如果填当前这个数字是否会打破规矩
            if(isValid(board,x,y,c)){
                board[x][y] = c;
                // 只要有一种情况成立，那么就可以返回
                if(backTrace(board,x,y+1)) return true;
                //回溯
                board[x][y] = 'c';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        for(int i=0;i<9;i++){
            if(board[x][i]==c)
                return false;
            if(board[i][y]==c)
                return false;
            if(board[x/3*3 +i/3][y/3*3+i%3]==c)
                return false;
        }
        return true;
    }
}
