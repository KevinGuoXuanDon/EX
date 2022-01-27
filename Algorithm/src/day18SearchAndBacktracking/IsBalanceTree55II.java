package day18SearchAndBacktracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true
 */
public class IsBalanceTree55II {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val =x;
        }
    }
    //BFS
    //1ms 67.27%
    //41.7mb
    //但是有一说一这种方式是迭代嵌套递归，用到了上一题的解法来计算子树的深度，然后比较每个节点的左右子树的深相差是否大于1
    //时间复杂度O(n^2)，相当于对遍历每个节点并且每个节点做了一次递归，并且使用了队列的额外空间= =，相比于直接DFS要差点
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null) {
                int left = getDeepth(node.left);
                int right = getDeepth(node.right);
                if (Math.abs(left - right) > 1) return false;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return true;
    }
    public int getDeepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDeepth(root.left),getDeepth(root.right))+1;
    }

    //如何自下而上的思想解决该题?
    //后序遍历左右根
    //0ms 100% 时间复杂度O(n)
    public boolean isBalancedByDFS(TreeNode root){
        if(root==null) return true;
        return recur(root)!= -1;
    }
    public int recur(TreeNode root){
        if(root==null) return 0;
        //进入左循环
        int left = recur(root.left);
        //进入右循环
        int right = recur(root.right);
        //如果已经发现不是平衡二叉树，返回-1
        if(left==-1 || right == -1 || Math.abs(left-right)>1) return -1;
        //否则计算当前长度
        else return Math.max(left,right)+1;
    }

    //自上而下，先序遍历，暴力破解
    //1ms 67.27
    //41mb
    public boolean isBalancedByDFSPreOrder(TreeNode root){
        if(root==null) return true;
        return Math.abs(getDeepth(root.left)-getDeepth(root.right))<=1 && isBalancedByDFSPreOrder(root.left) && isBalancedByDFSPreOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left=null;
        n1.right= n2;
        IsBalanceTree55II isBalanceTree55II = new IsBalanceTree55II();
        System.out.println(isBalanceTree55II.isBalanced(n1));
    }
}
