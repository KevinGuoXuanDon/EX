package Compete;

import java.util.*;

public class PaintBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //大佬思路，从后往前遍历，因为之后的操作其实会对之前的操作进行覆盖
    private static void dfs(TreeNode root, Set<Integer> nums) {
        if (root != null) {
            nums.add(root.val);
            dfs(root.left, nums);
            dfs(root.right, nums);
        }
    }

    public int getNumberByDESC(TreeNode root, int[][] ops) {
        int result = 0;
        int n = ops.length;
        TreeSet<Integer> nums = new TreeSet<>();
        // 中序遍历得到树的节点值
        dfs(root, nums);
        for (int i = n; --i >= 0;) {
            // 通过subset进行从min到max的取值，并且在染色后进行删除，避免重复计算问题
            Set<Integer> subset = new HashSet<>(nums.subSet(ops[i][1], ops[i][2] + 1));
            // 红色的话result++
            if (ops[i][0] == 1) result += subset.size();
            nums.removeAll(subset);
        }

        return result;
    }



    Set<TreeNode> red = new HashSet<>();
    Set<TreeNode> blue = new HashSet<>();
    // 我的思路：直接进行二分查找（直接在二叉搜索树上进行或者中序遍历后通过list进行），从前往后模拟每一次染色
    public int getNumber(TreeNode root, int[][] ops) {
        for(int i=0; i<ops.length; i++){
            int color = ops[i][0];
            int min = ops[i][1];
            int max = ops[i][2];
            paint(root,min,max,color);
        }
        return red.size();
    }
    public void paint(TreeNode root, int min, int max,int color){
        if(root==null) return;
        if(root.val<min){
            paint(root.right,min,max,color);
        }
        else if(root.val>max){
            paint(root.left,min,max,color);
        }
        else{
            if(color==1){
                if(blue.contains(root)) blue.remove(root);
                red.add(root);
            }
            else{
                if(red.contains(root)) red.remove(root);
                blue.add(root);
            }
            paint(root.right,min,max,color);
            paint(root.left,min,max,color);
        }
    }

}


