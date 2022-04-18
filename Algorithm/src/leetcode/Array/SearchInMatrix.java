package leetcode.Array;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 输入：matrix = [[1,4,7,11,15],
                [2,5,8,12,19],
                [3,6,9,16,22],
                [10,13,14,17,24],
                [18,21,23,26,30]],
 target = 5
 输出：true

 */
public class SearchInMatrix {
    // 三种思路：暴力搜索mn，每一行做二分mlongn，Z形搜索m+n
    // Z形搜索。从矩阵左下角开始搜索，如果比目标数字大就往上走，小就往右走
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length-1;
        int y=0;
        int cur =matrix[x][y];
        while(inBound(x,y,matrix)){
            if(cur==target) return true;
            if(cur>target){
                x--;
            }
            if(cur<target){
                y++;
            }
            if(!inBound(x,y,matrix)) return false;
            cur = matrix[x][y];
        }
        return false;
    }
    public boolean inBound(int x, int y, int[][] matrix){
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length;
    }
}
