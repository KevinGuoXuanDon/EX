package leetcode.Tree;
import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 
 */
public class ZigZagLevelTravesal {
    // BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 1;
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(flag==1){
                    list.addLast(node.val);
                }
                else{
                    list.addFirst(node.val);
                }
            }
            flag = -flag;
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
