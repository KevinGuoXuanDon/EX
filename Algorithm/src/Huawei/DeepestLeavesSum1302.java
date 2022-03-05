package Huawei;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum1302 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int maxDepth=0;
    int max=0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        // return bfs(root);
        dfs(root,0);
        return max;
    }
    public void dfs(TreeNode node, int curDepth){
        if(node == null) return;
        if(curDepth>maxDepth){
            maxDepth = curDepth;
            max = node.val;
        }
        else if(curDepth == maxDepth){
            max += node.val;
        }
        dfs(node.left,curDepth+1);
        dfs(node.right,curDepth+1);
    }
    public int bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i = 0; i< size ; i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return sum;
    }
}
