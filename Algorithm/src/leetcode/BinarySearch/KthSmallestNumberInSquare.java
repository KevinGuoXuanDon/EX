package leetcode.BinarySearch;

/**
 * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。*
 * 你必须找到一个内存复杂度优于O(n2) 的解决方案。
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 */
public class KthSmallestNumberInSquare {
    // 二分查找，每次猜一个中间的数字，统计比这个数字小的数字有多少个，来觉得它是不是第k个最小的元素
    // 由于每行每列都是递增的，选取一个特殊点左下角，此时往上走一定递减，往右走一定递增。由此开始遍历
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m-1][n-1];
        while(left<right){
            int mid = left+ (right-left)/2;
            int count = binarySearch(matrix,mid);
            System.out.println("count: "+count+" mid:"+mid);
            if(count>=k){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    // 1  5  9
    // 10 11 13
    // 12 13 15
    public int binarySearch(int[][] matrix, int mid){
        int count = 0;
        int x=0, y=matrix.length-1;
        while(y>=0){
            //如果一开始就比目标大，直接往上走，本行舍弃
            if(matrix[y][x]>mid){
                y--;
            }
            // 遍历到最右端了或者已经贴近mid值了，往上走，记录本行
            else if(x == matrix[0].length-1 || matrix[y][x+1]>mid){
                y--;
                count+=x+1;
            }
            // 正常情况往右遍历
            else{
                x++;
            }
        }
        return count;
    }
}
