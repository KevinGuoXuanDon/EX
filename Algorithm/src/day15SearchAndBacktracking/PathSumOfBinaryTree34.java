package day15SearchAndBacktracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class PathSumOfBinaryTree34 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
        TreeNode(int x, TreeNode left, TreeNode right){
            val=x;
            this.left=left;
            this. right=right;
        }
    }
    private List<List<Integer>> result;
    private LinkedList<Integer> curList;
    public List<List<Integer>> pathSum(TreeNode root, int target){
        result = new LinkedList<>();
        curList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        recur(root, target,0);
        return result;
    }
    //1ms 99.99%
    //38.5MB 85.44%
    public void recur(TreeNode root, int target,int sum){
        //如果当前节点是空的,直接返回
        if(root==null) return;
        //已经找到叶子结点了
        if(root.left==null && root.right==null){
            //找到了一个路径和
            if(root.val+sum==target){
                curList.add(root.val);
                result.add(new LinkedList<>(curList));
                curList.removeLast();
            }
            //路径和不对，直接返回
            else return;
        }
        //还没找到叶子结点
        else{
            sum+=root.val;
            curList.add(root.val);
            recur(root.left, target, sum);
            recur(root.right, target, sum);
            curList.removeLast();
        }
    }

    //优化: 因为无论是否是根节点，当前节点都要被加入计算，加入后查看是否是根节点，判断值是否计算正确，如果不正确则返回左右子节点
    //这里不需要做其他任何操作因为你不能确定二叉树里面的节点值是否为负数
    //1ms 99.99%
    //38.6mb 71.55%
    public void recur2(TreeNode root, int target){
        if(root==null) return;
        curList.add(root.val);
        target-=root.val;
        if(root.left==null && root.right==null && target==0) result.add(new LinkedList<>(curList));
        recur2(root.left,target);
        recur2(root.right,target);
        curList.removeLast();
    }
}
