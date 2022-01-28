package day19SearchAndBacktracking;

public class LowestCommonAncestor68II {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    //之前两次遍历在这里还是可以使用，但是要DFS递归所有情况来找到这个节点了。
    // 更简单的方法是使用递归的方法先序遍历，分别查找左右子树
    //如果找到叶子结点没有找到p,q，返回空，找到了p或者q，则返回对应节点
    //如果左子树返回空，说明p，q在右边子树，否则就在左子树，如果左右子树都不为空，说明pq分布在两侧，当前节点则为最小公共祖宗节点
    // 6ms 100%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p , TreeNode q){
        if (root==null || root==q || root==p) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //这句其实可以省略,因为返回的还是root
        if(left !=null && right!=null) return root;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
