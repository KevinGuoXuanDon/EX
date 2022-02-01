package day20DivideAndConquer;

 class VerifyPostorder33 {
    public boolean verifyPostorder (int[] postorder) {
        return recur(postorder,0, postorder.length-1);
    }
    public boolean recur(int[] postorder, int left, int right){
        if(left>=right) return true;
        int p = left;
        while(postorder[p]<postorder[right]) p++;
        int m = p;
        while(postorder[p]>postorder[right]) p++;
        return p == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }

    public static void main(String[] args) {
        VerifyPostorder33 v = new VerifyPostorder33();
        int[] a  = new int[]{1,3,2,6,5};
        boolean b = v.verifyPostorder(a);
        System.out.println(b);
    }
}
