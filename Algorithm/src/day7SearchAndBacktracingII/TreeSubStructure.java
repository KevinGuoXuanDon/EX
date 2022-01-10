package day7SearchAndBacktracingII;

import day6SearchAndBacktracking.PrintBinaryTree32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class TreeSubStructure {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //层序遍历存储到List中，然后对比短List是否是长List的子类
    /**
     *  事实证明，无论是层序遍历，前序遍历，中序遍历还是后序遍历得到List后进行比对，都无法直接解决这个问题，比如遇到如下情况：
     *  层序：
     *  [4,2,3,4,5,6,7,8,9]
     *  [4,8,9]

     *  前序：
     *  [10,12,6,8,3,11]
     *  [10,12,6,8]

     *  中序：
     *  [2,3,2,1]
     *  [3,null,2,2]
     *
     *  不能通过转化为的数组或者列表进行比对，而是要直接进入树的结构，如下面的递归：
     *  因为它有一个首要条件是，如果子树中没有这个节点，则直接返回true不需要判断，这解决了绝大部分特殊情况。
     *          if (B==null) return true;
     *  递归题想的复杂反而不好解决。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        List<Integer> la = levelOrder(A);
        List<Integer> lb =  levelOrder(B);
        for (int i:la) {
            System.out.print(i);
        }
        System.out.println("");
        for (int i:lb) {
            System.out.print(i);
        }
        for (int i = 0; i < la.size(); i++) {
            if (la.get(i)==lb.get(0)){
                boolean mark = false;
                for (int j = 0; j < lb.size(); j++) {
                    if(i+j>la.size()-1) {
                        mark=false;
                        break;
                    }
                    if(la.get(i+j)!=lb.get(j)){
                        mark=false;
                        break;
                    }
                    else mark=true;
                }
                if(mark==true) return true;
            }
        }
        return false;
    }

    public List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return result;
    }

    //直接先序遍历，首先在A树中找到和B根节点值相同的节点，然后进行比对是否能够相等
    //0ms 100%
    //39.9MB 85.57%
    public boolean isSubStructureDFS(TreeNode A, TreeNode B){
        if(A==null || B==null) return false;
        return recur(A,B)||isSubStructureDFS(A.left,B)||isSubStructureDFS(A.right,B);
    }
    public boolean recur(TreeNode A, TreeNode B){
        if (B==null) return true;
        if (A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
