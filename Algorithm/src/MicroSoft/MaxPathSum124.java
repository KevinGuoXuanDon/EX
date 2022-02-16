package MicroSoft;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *          -10
 *      9        20
 *             15   7
 */
public class MaxPathSum124 {
    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        getMaxSum(root);
        path.stream().forEach(System.out::println);
        return maxSum;
    }
    //dp[c] = Math.max(dp[left],0) + Math.max(dp[right],0) + c.val
    public int getMaxSum(TreeNode node){
        if(node == null){
            return 0;
        }
        //无论是计算当前根节点的最大和，还是向上返回，都不需要左右子树是负值，直接剔除
        int leftNodeVal = Math.max(getMaxSum(node.left),0);
        int rightNodeVal = Math.max(getMaxSum(node.right),0);
        //以当前节点为根节点计算最大和
        int sum = node.val+leftNodeVal+rightNodeVal;
        maxSum = Math.max(sum,maxSum);
        //以当前节点为子树，向上返回
        return node.val+Math.max(leftNodeVal,rightNodeVal);
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    int maxSum2=Integer.MIN_VALUE;
    List<Integer> path = new ArrayList<>();
    //打印路径的版本
    public ValuePath getSumAndPath(TreeNode node){
        if (node == null) return new ValuePath(0,new ArrayList<>());

        ValuePath leftValuePath = getSumAndPath(node.left);
        ValuePath rightValuePath = getSumAndPath(node.right);

        //先写向上返回
        int sum = node.val;
        List<Integer> path = new ArrayList<>();
        if(leftValuePath.value>0 && leftValuePath.value > rightValuePath.value){
            sum+= leftValuePath.value;
            path.addAll(leftValuePath.path);
            path.add(node.val);
        }
        else if(rightValuePath.value>0 && rightValuePath.value > leftValuePath.value){
            sum+= rightValuePath.value;
            path.add(node.val);
            path.addAll(rightValuePath.path);
        }
        else{
            path.add(node.val);
        }

        //判断当前的根，通过上面的筛选，sum里面已经剔除了左右子树值中的负数,并且选取了某一个不为负数的子树和当前节点值求和
        if(sum>maxSum2){
            this.maxSum2=sum;
            this.path=path;
        }
        //但是上面没有判断，如果左右都不为负数时的情况，这里补充,sumLCR is sumOfLeftNodeAndCUrrentNodeAndRightNode
        int sumLCR=leftValuePath.value+node.val+ rightValuePath.value;
        if(sumLCR>maxSum2){
            maxSum2=sumLCR;
            List<Integer> list = new ArrayList<>();
            list.addAll(leftValuePath.path);
            list.add(node.val);
            list.addAll(rightValuePath.path);
            this.path=list;
        }
        return new ValuePath(sum,path);
    }


    //Value and Path
    class ValuePath{
        int value;
        List<Integer> path;
        public ValuePath(int value, List<Integer> path){
            this.value=value;
            this.path=path;
        }
    }
}
