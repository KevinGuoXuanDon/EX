package day6SearchAndBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree32III {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    //广度
    //1ms 97.83%
    //38.5MB 71.20%
    public List<List<Integer>>  levelOrder(TreeNode root){
        List<List<Integer>> result= new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        LinkedList<Integer> temp;
        int count=0;
        while (!queue.isEmpty()){
            temp = new LinkedList<>();
            int size = queue.size();;
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                if(count%2==0) temp.addLast(node.val);
                else temp.addFirst(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            count++;
            result.add(temp);
        }
        return result;
    }

}
