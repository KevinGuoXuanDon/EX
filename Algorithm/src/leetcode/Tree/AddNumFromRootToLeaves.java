package leetcode.Tree;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *          4
 *      9       0
 *   5    1
 */
public class AddNumFromRootToLeaves {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root,0);
    }
    public int dfs(TreeNode node, int curValue){
        if(node==null) return 0;
        curValue = curValue*10+node.val;
        if(node.left==null && node.right==null){
            return curValue;
        }
        else {
            return dfs(node.left,curValue) + dfs(node.right,curValue);
        }
    }
}
