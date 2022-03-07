package Compete;

import java.util.*;

public class BuildTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * https://leetcode-cn.com/problems/create-binary-tree-from-descriptions/
     * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
     *
     * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
     * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
     * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
     * 测试用例会保证可以构造出 有效 的二叉树。
     *
     * 方法：直接模拟树的生成。先用hashmap保存和建立每一个节点，处理当前节点和子节点
     * 因为最后需要返回树根，则需要找到不为子节点的节点作为root，则用set记录所有的子节点，最后查找set中不包含的map键
     * @param descriptions
     * @return
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> childRecord = new HashSet<>();
        //for循环把每一个节点描述拿过来，生成对于的节点同时处理子节点.
        for(int[] i:descriptions){
            //处理当前节点
            if(!map.containsKey(i[0])){
                TreeNode node = new TreeNode(i[0]);
                map.put(i[0],node);
            }
           //处理子节点，如果不为空就直接用，为空就初始化塞入map
            TreeNode node = map.get(i[1]);
            if(node == null){
                node = new TreeNode(i[1]);
                map.put(i[1],node);
            }
            //记录一下子节点
            childRecord.add(i[1]);
            //处理完子节点之后就可以添加了
            if(i[2]==1){
                map.get(i[0]).left = node;
            }
            else map.get(i[0]).right=node;
        }
        //找根节点返回
        for(int key:map.keySet()){
            if(!childRecord.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}
