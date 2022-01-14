package day9DynamicProgramming;

public class Backpack {
    int[ ] value = {0,2,4,3,7};
    int[ ] weight = {0,2,3,5,5};
    int item=4;
    int capacity=10;
    //动态规划填表法
    public int backPack(){
        int[][] dp =new int[item+1][capacity+1];
        for (int i = 1; i < item; i++) {//考虑第i个物品
            for (int j = 1; j < capacity; j++) {//当背包容量为j时
                if(j<weight[i]) dp[i][j] = dp[i-1][j];//装不下
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);//比较拿和不拿，那个value更大
                }
            }
        }
        return dp[item][capacity];
    }

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        int a = backpack.backPack();
        //System.out.println(a);
    }
}
