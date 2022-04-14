package leetcode.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致
 * 详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *  root = [1,2,3,null,null,4,5]
 *  输出：[1,2,3,null,null,4,5]
 *
 */
public class SerializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return initList(root,"");
    }
    public String initList(TreeNode root, String str){
        if(root==null){
            return str+"null,";
        }
        str += root.val+",";
        str = initList(root.left,str);
        str = initList(root.right,str);
        return str;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(strs));
        TreeNode root = getTree(list);
        return root;
    }
    public TreeNode getTree(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = getTree(list);
        root.right = getTree(list);
        return root;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
