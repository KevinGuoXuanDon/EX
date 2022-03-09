package leetcode;

import java.util.LinkedList;

//把一颗二叉树以中序遍历的形式转换为双向链表
public class TreeToDoubleList36 {
    Node head;
    Node pre;
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }
    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);
        if(pre == null){
            head = cur;
        }
        else{
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
