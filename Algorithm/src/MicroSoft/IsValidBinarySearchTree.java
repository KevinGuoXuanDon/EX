package MicroSoft;

public class IsValidBinarySearchTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    long lastValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
//        return recur(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean recur(TreeNode root, long lower, long upper){
        if(root==null) return true;
        if(root.val<=lower || root.val>=upper) return false;
        return recur(root.left,lower,root.val) && recur(root.right,root.val,upper);
    }
    public boolean inOrder(TreeNode root){
        if(root==null) return true;
        boolean left = inOrder(root.left);
        if(!left) return false;
        if(root.val<=lastValue) return false;
        lastValue = root.val;
        boolean right = inOrder(root.right);
        return right;
    }
}
