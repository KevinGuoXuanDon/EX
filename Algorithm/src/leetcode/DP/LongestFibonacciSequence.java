package leetcode.DP;

import java.util.HashMap;

public class LongestFibonacciSequence {
    // 这题的dp有点灵活，dp[i][j]表示的是最长斐波那契子序列的最后两个下标，值表示的是长度。
    // 所以对每两个下标i,j进行枚举，找到它们相加的值是否存在数组中，如果存在target，取出它的下标，更新最后两个下标为dp[j][k]
    // 有点难，我估计想不出来= =
    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length<3) return 0;
        int[][] dp = new int[arr.length][arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],i);
        }
        int ans=0;
        for(int i =0; i< arr.length-2; i++){
            for(int j =i+1; j<arr.length-1; j++){
                int target = arr[i]+arr[j];
                int k = map.getOrDefault(target,-1);
                if(k !=-1){
                    if(dp[i][j]==0){
                        dp[i][j] = 2;
                    }
                    dp[j][k] = dp[i][j]+1;
                    ans = Math.max(dp[j][k],ans);
                }
            }
        }
        return ans;
    }
}
