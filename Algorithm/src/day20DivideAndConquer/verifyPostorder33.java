package day20DivideAndConquer;

import java.util.Stack;

class VerifyPostorder33 {
    //利用二叉搜索树的特性，左子树一定比根节点小，右子树一定比根节点大
    //利用后序遍历 左右根的特性，最后一个节点根肯定是根节点，可以根据和根节点值对比，找到最有子树的分割点。
    //这是遍历数组，如果是正常的后序遍历，先遍历到第一个右字数节点（找到第一个比根节点大的），后续的都需要比根节点大。
    //所以需要能完成遍历时，遍历的index要等于根节点的index，然后在看左右字数能否完成。
    //时间复杂度平方级别， 0ms 100%
    public boolean verifyPostorder (int[] postorder) {
        return recur(postorder,0, postorder.length-1);
    }
    public boolean recur(int[] postorder, int left, int right){
        if(left>=right) return true;
        int p = left;
        while(postorder[p]<postorder[right]) p++;
        //记录左右字数分割点
        int m = p;
        while(postorder[p]>postorder[right]) p++;
        return p == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }

    //单调栈解决:
    //如果数组是正序遍历，则是左右根的后续比那里方式。如果对数组逆序遍历呢？
    //对树的遍历方式为根右左。那么每次到"左"时，节点值肯定要变小，要小于当前节点的根节点,此时root进行更新，更新到它的父节点
    //每次都判断root和当前节点关系，因为这种方式一定是节点要小于父节点的根节点，一旦大于则不是后序遍历。
    //时间复杂度为o(n)，1ms 22.45%
    public boolean verifyPostorderByStack(int[] postorder){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >=0 ; i--) {
            if(postorder[i]>root) return false;
            while(!stack.isEmpty() && postorder[i]<stack.peek()) root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }



    public static void main(String[] args) {
        VerifyPostorder33 v = new VerifyPostorder33();
        int[] a  = new int[]{1,3,2,6,5};
        boolean b = v.verifyPostorder(a);
        System.out.println(b);
    }
}
