package Huawei;
import java.util.Scanner;
//编辑距离，把一个字符串变成另一个的最小步骤
public class Levenshtein {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            dp(a,b);
        }
    }
    public static void dp(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =1; i<=m;i++){
            dp[i][0] =i;
        }
        for(int i =1; i<=n;i++){
            dp[0][i] =i;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //每次考虑以当前字符结尾，如果相同，那么不用操作，操作数等于上一次的
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                //否则需要操作
                else{
                    //dp[i-1][j],对String a进行删除
                    //dp[i][j-1],对String a进行插入(也可以理解为对b，进行删除)
                    //dp[i-1][j-1]，进行了替换操作，所以都考虑之前的下标
                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        System.out.print(dp[m][n]);
    }
}
