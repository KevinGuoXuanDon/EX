package leetcode.Tree;

/**
 * 6057. 统计值等于子树平均值的节点数
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 *
 * 注意：
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 *
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 *
 *
 * 非常非常典型的一个二叉树题，相当于同时计算了子节点数量和子节点和
 */
public class CountNodeEqualToAVG {
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null)
            return 0;
        treeSum(root);
        return ans;
    }
    //DFS 后序一次遍历，可以通过数组来装在和与子节点数
    public int[] treeSum(TreeNode root){

        int[] left = new int[]{0,0};
        if(root.left!=null)
            left = treeSum(root.left);
        int[] right = new int[]{0,0};
        if(root.right!=null)
            right = treeSum(root.right);
        // 当前节点和为左右子节点和加上自身值
        int sum = left[0]+right[0]+root.val;
        // 当前节点数量为左右子节点加上自己
        int count = left[1] + right[1] +1; 
        if(sum/count==root.val)
            ans++;
        return new int[]{sum,count};
    }
}
