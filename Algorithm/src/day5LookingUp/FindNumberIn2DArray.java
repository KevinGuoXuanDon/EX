package day5LookingUp;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class FindNumberIn2DArray {
    //在每一行里用二分查找，但是这样浪费了题目给的每一列也是递增的顺序。
    //0ms   100%
    //44.2MB    29.64%
    public boolean FindNumberIn2DArray(int[][] matrix, int target){
        if(matrix==null) return false;
        for (int i = 0; i < matrix.length; i++) {
               int low = 0;
               int high= matrix[0].length-1;
               if(high==target) return true;
               while(low<high){
                   int pivot = low+ (high-low)/2;
                   int pivotValue = matrix[i][pivot];
                   if(pivotValue==target) return true;
                   else if(pivotValue > target) high=pivot;
                   else if(pivotValue < target) low=pivot+1;
               }
        }
        return false;
    }
    //用二叉搜索树的方式,以左下角为节点root,右边的都比他大，上边的都比他小
    //0ms       100%
    //44.3MB    21.37%
    public Boolean FindNumberIn2DArray2(int[][] matrix, int target){
        //此时表示的是左下角的节点
        int row = matrix.length-1;
        int column=0;
        //不越界时进行查找
        while(row>=0 && column<matrix[0].length){
            //如果这一行最小的数字都大于目标，则更替到上一行
            if(matrix[row][column]>target) row--;
            //如果这一列最大的都小于目标，换到下一列
            else if(matrix[row][column]<target) column++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        FindNumberIn2DArray f = new FindNumberIn2DArray();
        System.out.println(f.FindNumberIn2DArray(matrix,5));
        System.out.println(f.FindNumberIn2DArray2(matrix,5));
    }
}
