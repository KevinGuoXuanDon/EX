package leetcode.Array.Differ;

/**
 * 1094. 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,
 * trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客
 * 接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int i=0;i<trips.length; i++){
            int pass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2]-1;
            diff[from] +=pass;
            diff[to+1] -= pass;
        }
        int[] station = new int[1001];
        station[0] = diff[0];
        if(station[0]>capacity) return false;
        for(int i =1; i<1001; i++){
            station[i] = station[i-1] + diff[i];
            if(station[i]>capacity) return false;
        }
        return true;
    }
}
