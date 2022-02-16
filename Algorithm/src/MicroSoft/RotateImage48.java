package MicroSoft;

/**
 * 二维数组旋转90度，要求空间复杂度为o1
 */
public class RotateImage48 {
    public void rotate(int[][] matrix){
        //上下反转
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp= matrix[i][j];
                matrix[i][j] = matrix[matrix[0].length-1-i][j];
                matrix[matrix[0].length-1-i][j] = temp;
            }
        }
        //对角线反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
