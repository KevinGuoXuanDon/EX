package MicroSoft;

import java.util.*;

public class InOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null ||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        return result;
    }
    public void recur(TreeNode node,List<Integer> result){
        if(node==null) return;
        recur(node.left,result);
        result.add(node.val);
        recur(node.right,result);
    }

    /**
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)O(1)。
     *
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 x）：
     *
     * 如果 x 无左孩子，先将 x 的值加入答案数组，再访问 x 的右孩子，即 x=x.right。
     * 如果 x 有左孩子，则找到 x 左子树上最右的节点（即左子树中序遍历的最后一个节点，x 在中序遍历中的前驱节点），
     * 我们记为 predecessor,根据predecessor 的右孩子是否为空，进行如下操作。
     * 如果 predecessor 的右孩子为空，则将其右孩子指向 x，然后访问 x 的左孩子，即 x=x.left。
     * 如果 predecessor 的右孩子不为空，则此时其右孩子指向 x，说明我们已经遍历完 x 的左子树，
     * 我们将 predecessor 的右孩子置空，将 x 的值加入答案数组，然后访问 x 的右孩子，即 x=x.right。
     * 重复上述操作，直至访问完整棵树。
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversalByMorris(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode pre =null;
        while(root!=null){
            if(root.left==null){
                result.add(root.val);
                root=root.right;
            }
            else{
                pre=root.left;
                while(pre.right!=null && pre.right!=root){
                    pre=pre.right;
                }
                if(pre.right==root){
                    result.add(root.val);
                    pre.right=null;
                    root=root.right;
                }
                else{
                    pre.right=root;
                    root=root.left;
                }
            }

        }
        return result;
    }
}
