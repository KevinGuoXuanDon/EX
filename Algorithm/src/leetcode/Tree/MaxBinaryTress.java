package leetcode.Tree;

/**
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 */
public class MaxBinaryTress {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length ==0){
            return null;
        }
        return recur(nums,0,nums.length);
    }
    public TreeNode recur(int[] nums, int left,  int right){
        if(left >= right) return null;
        int maxNum = -1;
        int index = 0;
        // 得到当前区间最大值
        for(int i=left; i<right; i++){
            if(nums[i]>maxNum){
                maxNum = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = recur(nums,left,index);
        root.right = recur(nums,index+1,right);
        return root;
    }
}
