package day7SearchAndBacktracingII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 【1，2，2，3，4，4，3，5，6，7，8，8，7，6，5】
 *                  1
 *          2               2
 *       3      4       4        3
 *     5   6  7   8   8   7    6    5
 */
public class SymmetricTree28 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    //DFS解：每一次比较左子节点的左节点 和 右子节点的右结点， 左子节点的右结点和右子节点的左节点
    //0ms 100%
    //36.3MB    75.14%
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode A, TreeNode B){
        if(A==null && B ==null) return true;
        if(A==null || B ==null) return false;
        if(A.val!=B.val) return false;
        boolean result;
        result = recur(A.left,B.right) && recur(A.right,B.left);
        return result;
    }
    //BFS:从根节点开始，每一次存储下一层的节点，如果为空则添加-1，不为空则添加节点值。
    //并且把下一层节点入队
    //1ms 7.38%
    //37.7MB 5.42%
    public boolean isSymmetricBFS(TreeNode root){
        if (root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> linkedList;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            linkedList= new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left==null) linkedList.add(-1);
                else{
                    linkedList.add(node.left.val);
                    queue.offer(node.left);
                }
                if(node.right==null) linkedList.add(-1);
                else{
                    linkedList.add(node.right.val);
                    queue.offer(node.right);
                }
            }
            if (linkedList.size()!=1&&linkedList.size()%2!=0) return false;
            for (int i = 0; i < linkedList.size()/2; i++) {
                if(linkedList.get(i)!=linkedList.get(linkedList.size()-1-i)) return false;
            }
        }
        return true;
    }

}
