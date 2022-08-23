package leetcode.Tree;
import java.util.*;
public class PrintBinaryTree {
    int height;
    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root);
        int weith = (1<<(height+1))-1;
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<height+1; i++){
            List<String> temp = new ArrayList<>();
            for(int j =0; j< weith; j++){
                temp.add("");
            }
            res.add(temp);
        }
        dfs(root,res,0, (weith-1)/2);
        return res;
    }

    public void dfs(TreeNode root, List<List<String>> list, int r, int c){
        if(root==null){
            return;
        }
        List<String> temp = list.get(r);
        temp.set(c,root.val+"");
        if(root.left!=null){
            dfs(root.left,list,r+1,c-(1<<(height-r-1)));
        }
        if(root.right!=null){
            dfs(root.right,list,r+1,c+(1<<(height-r-1)));
        }
    }

    public int getHeight(TreeNode root){
        int count = 0;
        if(root.left!=null){
            count = Math.max(count, getHeight(root.left)+1);
        }
        if(root.right!=null){
            count = Math.max(count,getHeight(root.right)+1);
        }
        return count;
    }
}
