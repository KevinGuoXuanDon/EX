package Huawei;

/**
 * 买彩票，求最高利润，每天手上最多持有1张彩票
 * prices = [1,2,3,4,5]
 * 彩票每天浮动价格如上
 * 每天都可以买入或者卖出
 */
public class BuyStock {
    public int maxProfit(int[] prices) {
        // 两种写法
        // 1. 动态规划
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for(int i=1; i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
    /**
     2. 一次遍历。其实两种时间复杂度都是o(n)，时间复杂度动态规划优化后其实也常数级别
     */
    public int iterative(int[] prices){
        int sum=0;
        for(int i=1; i<prices.length; i++){
            int profit = prices[i]-prices[i-1];
            sum = profit>0? sum+profit: sum;
        }
        return sum;
    }
}
