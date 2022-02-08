package day25Stimulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuandongguo

 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int top= 0,down =matrix.length-1;
        int left=0,right = matrix[0].length-1;
        int[] result = new int[matrix.length*matrix[0].length];
        int count=0;
        while(true){
            //从左往右走，走完第一行之后，top需要更新，下次top就需要在1的位置而不是0了。
            for (int i = left; i <= right; i++) {
                result[count++] = matrix[top][i];
            }
            if(++top>down){
                break;
            }
            //从上往下走，走完最右边的列之后，right需要更新。
            for (int i = top; i <= down; i++) {
                result[count++] = matrix[i][right];
            }
            if(left>--right){
                break;
            }
            //从右往左走，走完最后行之后，down需要更新。
            for (int i = right; i >=left; i--) {
                result[count++] = matrix[down][i];
            }
            if(top>--down){
                break;
            }
            //从下往上走，走完第一列之后，left需要更新
            for (int i = down; i >= top; i--) {
                result[count++] = matrix[i][left];
            }
            if(++left>right){
                break;
            }
        }
        return result;
    }
}
