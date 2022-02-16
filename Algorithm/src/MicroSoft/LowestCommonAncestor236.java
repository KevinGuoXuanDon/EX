package MicroSoft;

/**
 * 给定一个无重复数字的二叉树，给定两个节点p，q，返回他们的最小公共祖节点
 */
public class LowestCommonAncestor236 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    //如果根节点为空，或者p，q中某一个是根节点，都返回这个节点
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
        if(root==null || q==root || p==root) return root;
        //去左子树寻找是否有p或者q，找到了则会返回节点，没找到则返回了空值
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        //同理在右子树中查找
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if(leftNode!=null && rightNode!=null){
            //若左右子树都有子节点，说明当前根节点就是最小公共祖树
            return root;
        }
        else if(leftNode==null){
            //左子树中没有找到p，q，都在右子树，则进入右子树寻找
            return rightNode;
        }
        else{
            //同上，进入左子树寻找
            return leftNode;
        }
    }
    //如果当前的子树是一颗二叉搜索树呢?
    public TreeNode lowestCommonAncestorForBinarySearchTree(TreeNode root, TreeNode p, TreeNode q){

        //BFS解决，时间复杂度最差能到O（n）,更快的方式是通过binarySearch
        //特殊情况照旧返回
        if(root ==null || p==root || q==root) return root;
        //p,q都比根节点小，返回左子树查询
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestorForBinarySearchTree(root.left,p,q);
            //p,q都比根节点大，返回右子树查询
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestorForBinarySearchTree(root.right,p,q);
            //分布在两端，则当前节点就是最小公共祖先
        else{
            return root;
        }
    }

    //二分查找
    public TreeNode lowestCommonAncestorForBSTByBS(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || p==root || q==root) return root;
        int max= Math.max(p.val,q.val);
        int min= Math.max(p.val,q.val);
        while(root!=null){
            if(root.val>min && root.val<max) return root;
            else if (root.val>max) root=root.left;
            else root=root.right;
        }
        return null;
    }
}
