package Compete;

/**
 * 2218. 从栈中取出 K 个硬币的最大面值和
 * 一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 *
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 *
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组
 * 分别表示第 i 个栈里 从顶到底 的硬币面值。
 * 同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 *  输入：piles = [[1,100,3],[7,8,9]], k = 2
 *  输出：101
 */
import java.util.*;
public class MaxCoinValue {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int size=piles.size();
        int[][] dp = new int[size][k+1];
        // 先考虑只拿第一个栈的
        for(int i = 1; i<=k && i<=piles.get(0).size(); i++){
            dp[0][i] =  dp[0][i-1] + piles.get(0).get(i-1);
        }
        //i表示可以选择第i个槽
        for(int i = 1; i< size; i++){
            // j 表示可以拿几次
            for(int j=1; j<=k;j++){
                int sum = 0;
                //m表示这个槽拿几个物品
                for(int m=0; m<= piles.get(i).size(); m++){
                    if(m>=1) sum+= piles.get(i).get(m-1);
                    //如果能放得下,就选择拿还是不拿
                    if(j>=m) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-m] + sum);
                }
            }
        }
        return dp[size-1][k];
    }
}
