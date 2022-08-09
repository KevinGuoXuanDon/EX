package leetcode.BinarySearch;

/**
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 *
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，
 * 其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 *
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 *
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 *
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 */
public class FindPeakElementII {
    /**
     * 每一行寻找最大值，知道逼近一个最大值使得峰值成立
     */
    public int[] findPeakGrid(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = n-1;
        int mid = 0,  midIndex = 0;
        while(left<right){
            mid = left + ( (right-left)>>1);
            midIndex = getMax(mat[mid]);
            if(mat[mid][midIndex]>mat[mid+1][midIndex]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return new int[]{left,midIndex};
    }

    private int getMax(int[] ints) {
        int index = 0;
        int max = -1;
        for(int i=0; i<ints.length; i++){
            if(max<ints[i]){
                index = i;
                max = ints[i];
            }
        }
        return index;
    }
}
