package leetcode.Stimulate;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix =
 * [
 * [1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class SpiralMatrix {
    // 一层一层遍历
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return new ArrayList<>();
        int left =0, top =0;
        int right = matrix[0].length-1, bottom = matrix.length-1;
        List<Integer> list = new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            for(int i=right;i>=left && top<=bottom;i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top && left<=right;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
