package day15SearchAndBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 找出二叉搜索树中第K大的节点的值
 */
public class GetKthLargest54 {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    //逆中序遍历，用list存储并且返回, 说实话用中序遍历的话0ms，暂时没想通为啥
    //1ms
    //39.2MB
    public int kthLargest(TreeNode root, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        rInOrder(root,k,result);
        return result.get(k-1);

    }
    public void rInOrder(TreeNode root, int k, LinkedList<Integer> result){
        if(root==null) return;
        rInOrder(root.right,k,result);
        result.add(root.val);
        if(result.size()==k) return;
        rInOrder(root.left,k,result);
    }

    //中序遍历
    //0ms 反而比逆中序遍历要快？？？
    public int kthLargest2(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        InOrder(root,result);
        return result.get(result.size()-k);

    }
    public void InOrder(TreeNode root, ArrayList<Integer> result){
        if(root==null) return;
        InOrder(root.left,result);
        result.add(root.val);
        InOrder(root.right,result);
    }



    private int res, n;
    //0ms
    //38.1MB
    public int kthLargest1(TreeNode root, int k) {
        n = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null || n == 0) return;
        dfs(node.right);
        if (--n == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }

}
