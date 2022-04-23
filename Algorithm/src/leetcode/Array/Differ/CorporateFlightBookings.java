package leetcode.Array.Differ;

/**
 * 算法思想
 * 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减
 * 这里就需要差分数组的技巧，类似前缀和技巧构造的 prefix 数组
 * 先对 nums 数组构造一个 diff 差分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差
 * 比如 nums[] = { 8, 2, 6, 3, 1 }
 *  则 diff[] = { 8, -6, 4, -3, -2}
 * 可以快速进行区间增减的操作，你想对区间 nums[i..j] 的元素全部加 3，
 * 那么只需要让 diff[i] += 3，然后再让 diff[j+1] -= 3 即可：相当于i及之后的所有元素+3， j+1及之后的所有元素-3
 * 此时 diff[] = { 8, -3, 4, -3, -5}
 *     nums[] = { 8,  5, 9,  6,  1}
 */

/**
 * 题目
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表bookings
 * 表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 *
 * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
 *
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        for(int i=0;i<bookings.length; i++){
            int first = bookings[i][0]-1;
            int last = bookings[i][1]-1;
            int seats = bookings[i][2];
            diff[first] +=seats;
            diff[last+1] -= seats;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for(int i=1; i<n; i++){
            res[i] = res[i-1]+diff[i];
        }
        return res;
    }
}
