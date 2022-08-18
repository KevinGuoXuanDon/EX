package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 0;
            for(int i=0;i<size; i++){
                TreeNode node = queue.poll();
                count += node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res = count;
        }
        return res;
    }
}
