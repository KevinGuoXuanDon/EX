package leetcode.DoublePointer;
import java.util.*;

/**
 * 给定两个人的空闲时间表：slots1 和 slots2，以及会议的预计持续时间duration，
 * 请你为他们安排时间段最早且合适的会议时间。
 *
 * 如果没有满足要求的会议时间，就请返回一个 空数组。
 *
 * 「空闲时间」的格式是[start, end]，
 * 由开始时间start和结束时间end组成，表示从start开始，到 end结束。
 *
 * 题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说
 * ，对于同一个人的两个空闲时间[start1, end1]和[start2, end2]，
 * 要么start1 > end2，要么start2 > end1。
 *
 * 示例 1：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * 输出：[60,68]
 * 示例 2：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * 输出：[]
 
 */
public class MeetingSchedule {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration){
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1,(o1,o2)->o1[0]-o2[0]);
        Arrays.sort(slots2,(o1,o2)->o1[0]-o2[0]);
        int index1 =0, index2 =0;
        int n = slots1.length, m = slots2.length;
        while(index1<n && index2 < m){
            int left = Math.max(slots1[index1][0],slots2[index2][0]);
            int right = Math.min(slots1[index1][1],slots2[index2][1]);
            if(right-left >= duration){
                res.add(left);
                res.add(left+duration);
                return res;
            }
            if(slots1[index1][1]>slots2[index2][1]){
                index2++;
            }
            else{
                index1++;
            }
        }
        return res;
    }
}
