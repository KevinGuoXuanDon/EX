package leetcode.Stimulate;

import java.util.Arrays;

/**
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],
 *      [5,0,-1,-1,1],
 *      [5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 */
public class SpiralMatrixIV {
    // 先填充-1，在把链表中的数据拿出来填充
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int top =0, left =0;
        int bottom =m-1, right=n-1;
        for(int i=0;i<m;i++)
            Arrays.fill(res[i],-1);
        while(top<=bottom && left<=right){
            for(int i=left; i<=right && head!=null; i++){
                res[top][i] = head.val;
                head = head.next;
            }
            top++;
            for(int i=top;i<=bottom && head!=null;i++){
                res[i][right] =head.val;
                head = head.next;

            }
            right--;
            for(int i=right; i>=left && head!=null; i--){
                res[bottom][i] = head.val;
                head = head.next;

            }
            bottom--;
            for(int i=bottom; i>=top && head!=null; i--){
                res[i][left] = head.val;
                head = head.next;

            }
            left++;
        }
        return res;
    }
    public class ListNode{
        int val;
        ListNode next;
    }
}
