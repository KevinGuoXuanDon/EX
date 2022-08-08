package leetcode.Tree;
import java.util.*;

/**
 * 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 *
 * 注意，根节点root位于深度1。
 *
 * 加法规则如下:
 *
 * 给定整数depth，对于深度为depth - 1 的每个非空树节点 cur ，
 * 创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着depth - 1根本没有深度，
 * 那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * 
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null){
            return root;
        }
        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDep = 1;
        while(!queue.isEmpty()){
            curDep++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                TreeNode left= node.left;
                TreeNode right = node.right;
                if(curDep == depth){
                    TreeNode addNodeLeft = new TreeNode(val);
                    TreeNode addNodeRight = new TreeNode(val);
                    node.left = addNodeLeft;
                    node.right = addNodeRight;
                    addNodeLeft.left = left;
                    addNodeRight.right = right;
                }else{
                    if(left!=null) queue.add(left);
                    if(right!=null) queue.add(right);
                }
            }
            if(curDep==depth){
                break;
            }
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
