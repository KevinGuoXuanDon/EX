package day6SearchAndBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree32II {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    //同样是广度优先
    //1MS 93.58%
    //38.5MB 77.14%
    public List<List<Integer>> PrintBinaryTree32II(TreeNode root){
        List<List<Integer>> result= new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> temp;

        while (!queue.isEmpty()){
            temp = new ArrayList<>();
            int size = queue.size();;
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            result.add(temp);
        }
        return result;
    }
}
