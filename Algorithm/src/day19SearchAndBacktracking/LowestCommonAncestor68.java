package day19SearchAndBacktracking;

import java.util.LinkedList;

public class LowestCommonAncestor68 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //思想：找到节点，他的值在p和q之间。

  //带上第一行if(root==null)， 6ms 60.24%, 去掉后5ms 100%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //安全考虑加上了这个空值直接返回，但是这个方法调用一般不会是空树，不然p和q直接报错了，第一行可以注释
        if(root==null) return root;
        else if (root.val>p.val && root.val >q.val) return lowestCommonAncestor(root.left,p,q);
        else if  (root.val<p.val && root.val <q.val)return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    //二分查找,看着上面的递归，很容想到只要找到一个节点，它的值在p和q的值之间（可取等），那这个值就是它们的公共祖先
    // 5ms 100%
    public TreeNode lowestCommonAncestorByBinarySearch(TreeNode root, TreeNode p , TreeNode q){
        if(root==null) return root;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val,q.val);
        while(root!=null){
            if(root.val>=min && root.val <= max){
                return root;
            }
            else if(root.val >max) root = root.left;
            else if(root.val <min) root= root.right;
        }
        return root;
    }

    //在写个麻烦一点的办法，分别遍历从root到p和q的路径，用链表记录下来，然后查询他们的最近的公共节点，就是他们的公共祖先
    //5ms 100%
    public TreeNode lowestCommonAncestorByTwiceTraverse(TreeNode root, TreeNode p, TreeNode q){
        LinkedList<TreeNode> pPath = getPath(root,p);
        LinkedList<TreeNode> qPath = getPath(root,q);
        TreeNode result = new TreeNode(0);
        for (int i = 0; i < pPath.size() && i<qPath.size(); i++) {
            if(qPath.get(i)==pPath.get(i)) result=pPath.get(i);
            //这一句不影响结果，但是可以节省一点时间复杂度
            else break;
        }
        return result;
    }
    public LinkedList<TreeNode> getPath(TreeNode root, TreeNode x){
        LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        TreeNode node =root;
        while(node!=x){
            path.add(node);
            if(node.val<x.val) node = node.right;
            else node = node.left;
        }
        path.add(node);
        return path;
    }
}
