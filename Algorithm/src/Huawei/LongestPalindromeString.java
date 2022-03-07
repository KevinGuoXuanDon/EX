package Huawei;
//查找String中的最长回文字串
// caabbaad         和 cabad
// aabbaa              aba
public class LongestPalindromeString {
    public int getLongestPalindrome (String A) {
        // write code here
        int max =1;
        for(int i=0;i<A.length();i++){
            //奇数时，从两边扩张
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<=A.length()-1){
                if(A.charAt(left)==A.charAt(right)){
                    max = Math.max(max,right-left+1);
                }else{
                    break;
                }
                left--;
                right++;
            }
            //偶数时,从i-1和i开始
            left = i-1;
            right =i;
            while(left>=0 && right<=A.length()-1){
                if(A.charAt(left)==A.charAt(right)){
                    max = Math.max(max,right-left+1);
                }else{
                    break;
                }
                left--;
                right++;
            }
        }
        return max;
    }
}
