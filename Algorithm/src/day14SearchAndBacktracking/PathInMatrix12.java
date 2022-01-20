package day14SearchAndBacktracking;

/**
 * 定一个m x n 二维字符网格board 和一个字符串单词word.
 * 如果word 存在于网格中，返回 true ；否则，返回 false.
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *  * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *  *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class PathInMatrix12 {

    //5ms 60.62%
    //40.1MB 55.47
    private int[][] flag;
    public boolean exist(char[][] board, String word) {
        flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==word.charAt(0) && recur(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    public boolean recur(char[][]board, String word, int length, int i, int j){
        //限制边界,找出边界了就直接返回flase
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        //这个位置已经用了，防止重复查找
        if(flag[i][j]==1) return false;
        //当前值不匹配
        if(board[i][j]!=word.charAt(length)) return false;
        //如果上面的特殊情况都没有触发，此时当前站点的点也是字符中的一个，标记当前点,进入下一步
        else{
            flag[i][j]=1;
            length++;
            if(length==word.length()) return true;
            if (recur(board,word,length,i+1,j)) return true;
            if (recur(board,word,length,i-1,j)) return true;
            if (recur(board,word,length,i,j+1)) return true;
            if (recur(board,word,length,i,j-1)) return true;
        }
        //如果找不到就返回flase
        flag[i][j]=0;
        return false;
    }
}
