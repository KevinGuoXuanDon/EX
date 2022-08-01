package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In a binary tree,
 * a lonely node is a node that is the only child of its parent node.
 * The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree,
 * return an array containing the values of all lonely nodes in the tree.
 * Return the list in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,4]
 * Output: [4]
 * Explanation: Light blue node is the only lonely node.
 * Node 1 is the root and is not lonely.
 * Nodes 2 and 3 have the same parent and are not lonely.
 */
public class FindAllLonelyNodes {
    List<Integer> list = new ArrayList();
    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return list;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right ==null){
            return;
        }
        if(root.left == null || root.right == null){
            list.add(root.right ==null? root.left.val : root.right.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    // BFS
    public List<Integer> getLonelyNodesByBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left!=null && right ==null){
                res.add(left.val);
            }
            if(right!=null && left ==null){
                res.add(right.val);
            }
            if(left!=null) queue.add(left);
            if(right!=null) queue.add(right);
        }
        return res;
    }
}
