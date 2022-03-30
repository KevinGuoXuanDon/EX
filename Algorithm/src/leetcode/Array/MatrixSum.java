package leetcode.Array;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回左上角 (row1,col1)、右下角(row2,col2)的子矩阵的元素总和。
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入: 
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出: 
 * [null, 8, 11, 12]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/O4NDxx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixSum {
    //方法：前缀和。拿一个数组，每一个位置sum[i][j] = matrix[0][j]+matrix[1][j]....matrix[i][j]，纵向和
    int[][] sum;
    public MatrixSum(int[][] matrix) {
        if(matrix.length>0){
            sum =new int[matrix.length+1][matrix[0].length+1];
            for(int i=0;i<matrix.length; i++){
                for(int j=0;j<matrix[0].length;j++){
                    sum[i+1][j] = sum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res =0;
        for(int i = col1;i<=col2;i++){
            int temp =sum[row2+1][i]-sum[row1][i];
            res += temp;
        }
        return res;
    }
}
