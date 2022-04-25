package leetcode.Tree;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *                  1
 *            2            3
 *               5              4
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 *                  1
 *           2              3
 *               5                 4
 *             6  7
 * 输入: [1,2,3,null,5,null,4,6,7]
 * 输出: [1,3,4,7]
 */
import java.util.*;
public class RightSideViewBinrayTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        dfs(res,root,0);
        return res;
    }
    // 如果使用深度优先搜索，需要在添加节点值时做一个限制： 当前深度和res的大小一致，保证一层添加一个节点，并且通过先右后左保证添加右节点
    // 深度一开始没写好
    public void dfs(List<Integer> res, TreeNode root, int depth){
        if(root==null){
            return;
        }
        if(res.size()==depth){
            res.add(root.val);
        }
        depth++;
        dfs(res,root.right,depth);
        dfs(res, root.left,depth);
    }

    public void bfs(List<Integer> res, TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = true;
            for(int i=size-1; i>=0;i--){
                TreeNode node = queue.poll();
                if(flag) {
                    res.add(node.val);
                    flag = false;
                }
                // 右视图，先加右边
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }
        }
    }
}
