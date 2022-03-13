package Huawei;

import java.util.Scanner;

public class GetPassword {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //中心扩散法处理回文串
        char[] ch = s.toCharArray();
        int n = ch.length;
        int max = 0;
        //奇数时
        for(int i=0; i<n;i++){
            int left=i;
            int right=i;
            while(left>=0 && right<=n-1 && ch[left]==ch[right]){
                max = Math.max(max,right-left+1);
                left --;
                right++;
            }
        }
        //偶数时
        for(int i=0;i<n;i++){
            int left = i-1;
            int right =i;
            while(left>=0 && right<=n-1 && ch[left]==ch[right]){
                max = Math.max(max,right-left+1);
                left --;
                right++;
            }
        }
        System.out.println(max);
    }
}
