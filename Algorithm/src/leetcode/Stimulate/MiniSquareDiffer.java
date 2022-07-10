package leetcode.Stimulate;

import java.util.*;

public class MiniSquareDiffer {
    //时间复杂度太高
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums1.length;i++){
            queue.add((long) Math.abs(nums1[i]-nums2[i]));
        }
        for(int i=0;i<k1+k2;i++){
            long count = queue.poll();
            if(count==0) break;
            count--;
            if(count<=0)
                queue.add(0l);
            else
                queue.add(count);
        }
        long res = 0;
        for(long l:queue){
            res+=l*l;
        }
        return res;
    }

    public static void main(String[] args) {

        long res =minSumSquareDiff(new int[]{10,10,10,11,5},new int[]{1,0,6,6,1},11,27);
        System.out.println(res);
    }
}
