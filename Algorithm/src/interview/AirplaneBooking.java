package interview;

import java.util.Scanner;

/**
 * @author Xuandong Guo
 * @date 14/11/2022
 */
public class AirplaneBooking {
    /**
     * 有 n 个航班，它们分别从 1 到 n 进行编号。
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [first i, last i, seats i] 意味着在从 first i 到 last i
     * （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     * 示例 1：
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     *
     * 示例 2：
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     */

    /**
     * Stimulation // diff // prefix
     * @param record
     * @return
     */
    public int[] bookingList(int n, int[][] record){

        // 边界条件
        int[] answer = new int[n];
        if(record == null){
            return answer;
        }
        // 取出每条记录进行计算
        for(int[] list : record){
            int firstI = list[0];
            int lastI = list[1];
            int seatsNum = list[2];
            for(int i = firstI; i<=lastI; i++){
                // 开始自增
                answer[firstI - 1] += seatsNum;
                answer[lastI - 1] += seatsNum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] bookings = new int[n][3];

        // 二维数组bookings初始化
        for(int i=0; i< n; i++){
            for(int j =0; j<3; j++){
                bookings[i][j] = sc.nextInt();
            }
        }
        AirplaneBooking airplaneBooking = new AirplaneBooking();
        // 实例方法调用
        int[] ans = airplaneBooking.bookingList(n,bookings);

        for(int i: ans){
            System.out.println(i+" ");
        }
    }
}
