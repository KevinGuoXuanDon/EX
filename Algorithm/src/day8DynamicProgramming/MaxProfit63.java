package day8DynamicProgramming;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class MaxProfit63 {
    //因为时间是单项往后走的，在每一天比较最小值，如果最小值有更新，说明此时可以考虑买入，在之后如果有值大于之前买入值，记录此时的利润
    //然后每一次卖出点都计算利润，并且和maxProfit进行对比，如果更大则进行更新。
    //1ms 98.83%
    //38.2MB 41.57
    public int maxProfit(int[] prices){
        int maxProfit=0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                if(maxProfit<prices[i]-minPrice) maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
