package day18SearchAndBacktracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *    return 3
 *
 *    递归的时间消耗都是0ms,迭代要更高，但是节省空间复杂度.
 */
public class MaxDepthOfBinaryTree55 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val =x;
        }
    }

    public int maxDepth(TreeNode root){
        return recur(root,0, 0);
    }
    // 记录一个小错误，由于细节犯的：之前在返回这个递归函数时的写法为：
    // return Math.max(recur(root.left,count++,max),recur(root.right,count++,max));并且前面没有单独count++
    // 此时会导致漏了一层，因为往下递归时，每次执行完一层后count才会自增，而要的是先自增，在往下走
    // 要么换成下面，要么老实写return Math.max(recur(root.left,count+1,max),recur(root.right,count+1,max));
    public int recur(TreeNode root, int count, int max){
        max = Math.max(count,max);
        if(root==null) return max;
        count++;
        return Math.max(recur(root.left,count,max),recur(root.right,count,max));
    }

    //更简单的写法
    public int maxDepth2(TreeNode root){
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //BFS
    //1ms
    //41.1mb    5.17% ???
    public int maxDepthByBFS(TreeNode root){
        int length = 0;
        if(root==null) return length;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree55 maxDepthOfBinaryTree55 = new MaxDepthOfBinaryTree55();
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t2;
        System.out.print(maxDepthOfBinaryTree55.maxDepth(t));
    }
}
