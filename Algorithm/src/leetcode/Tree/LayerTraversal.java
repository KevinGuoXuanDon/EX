package leetcode.Tree;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class LayerTraversal {
    public List<List<TreeNode>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<TreeNode>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> curLayer = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                curLayer.add(node);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(curLayer);
        }
        return res;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}