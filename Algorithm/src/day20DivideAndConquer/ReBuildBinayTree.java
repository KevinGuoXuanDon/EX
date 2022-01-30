package day20DivideAndConquer;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *           3
 *       9       20
 *             15   7
 */
class ReBuildBinayTree07 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //1ms 100%
    private HashMap<Integer,Integer> map;
    public TreeNode buildTreeNode(int[] preOrder, int[] inOrder){
        map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i],i);
        }
        int n = preOrder.length;
        return recur(preOrder,inOrder,0,n-1,0,n-1);
    }
    public TreeNode recur(int[] preOrder, int[] inOrder, int preOderLeft, int preOderRight, int inOrderLeft, int inOrderRight){
        if(preOderLeft>preOderRight) return null;
        int pre_root = preOderLeft;
        int in_root = map.get(preOrder[pre_root]);
        TreeNode root = new TreeNode(preOrder[preOderLeft]);
        int leftSize = in_root-inOrderLeft;
        root.left = recur(preOrder,inOrder,preOderLeft+1,preOderLeft+leftSize, inOrderLeft,in_root-1);
        root.right = recur(preOrder,inOrder,preOderLeft+leftSize+1,preOderRight,in_root+1,inOrderRight);
        return root;
    }
}
