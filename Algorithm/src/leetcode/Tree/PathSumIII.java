package leetcode.Tree;

import java.util.HashMap;

/**
 * 一道结合了Tree和prefix前缀和的题目，难度Medium
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 *                      10
 *               5              -3
 *           3      2               11
 *        3   -2      1
 *
 * 5+3, 5+2+1, -3+11三条路径,可以以前缀和的思想看
 * 使用一个HashMap来记录以及存在的路径，每次到一个节点时尝试当前路径和-目标和是否以及存在于HashMap中
 * 前缀和在数组题中可以用arr或者map储存，但是遇到其他类型的数据结构时，一半都用map
 */
public class PathSumIII {
    HashMap<Long,Integer> map;
    public int pathSum(TreeNode root,int targetSum){
        map = new HashMap<>();
        // 预先储存一个值为0的
        map.put(0l,1);
        return recur(root,0,targetSum);
    }

    public int recur(TreeNode node, long cur, int targetSum) {
        //当前节点如果为空，则当前节点不可能形成一个解
        if(node == null) return 0;
        //当前路径下来的累加值
        cur += node.val;
        int res = 0;
        res += map.getOrDefault(cur-targetSum,0);
        map.put(cur,map.getOrDefault(cur,0)+1);
        res+= recur(node.left,cur,targetSum);
        res+= recur(node.right,cur,targetSum);
        map.put(cur,map.getOrDefault(cur,0)-1);
        cur-=node.val;
        return res;
    }
}
