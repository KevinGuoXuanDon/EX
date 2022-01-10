package day7SearchAndBacktracingII;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class MirrorTree27 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    //先序遍历，交换左右节点递归
    //0ms 100%
    //35.9MB 36.83%
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return root;
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    public void swap(TreeNode root){
          TreeNode temp = root.left;
          root.left = root.right;
          root.right = temp;
    }
}
