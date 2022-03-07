package Huawei;
import java.util.Scanner;
//查找两个String的最长公共字串
//asdasf
//asdasg
//得到：asdas
public class LongestCommonSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            //题目优先较短串中最先出现的那个。
            if(a.length()<b.length()) dp(a,b);
            else dp(b,a);
        }
    }
    public static void dp(String a,String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        int length = 0;
        int index=0;
        //为了避免-1的出现，整体下标往右边移动一位，当前遍历的其实是下表i-1和j-1的元素
        for(int i =1; i<= m; i++){
            for(int j=1; j<=n ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    //所以这里放弃dp[0][0]这个位置，第一个a的元素和b的元素用dp[1][1]装
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j]>length){
                        length = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        System.out.println(a.substring(index-length,index));
    }
}
