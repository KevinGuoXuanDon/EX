package leetcode.Stimulate;

import java.util.*;

public class MiniSquareDiffer {
    //时间复杂度太高 O(2n+(k1+k2)logn) -> O((k1+k2)log(n))
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

    // 上面提交不通过说明主要时间复杂度可能是卡在了(k1+k2)上,说明此处需要优化
    // 贪心+优先队列,每次只处理一个元素效率太低，需要批次处理，此时需要再加一个数据结构：Map
    // 60ms 34%
    public long minSumSquareDiffUpdated(int[] nums1, int[] nums2, int k1, int k2){
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[0]-o1[0]));
        long res = 0;
        int n = nums1.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i]-nums2[i]);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            queue.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int k = k1+k2;
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int diff = arr[0];
            int len = arr[1];
            if(diff==0) {
                continue;
            }
            if(k==0){
                res += 1L*diff*diff*len;
                continue;
            }
            int reduceCount = (diff-queue.peek()[0])*len;
            if(k>=reduceCount){
                k-=reduceCount;
                queue.peek()[1]+=len;
            }
            else{
                // c和t分别表示全部-1的次数和部分-1的次数
                int c=k/len,t=k%len;
                if(diff-c>0){
                    diff-=c;
                    res+=1L*(diff-1)*(diff-1)*t+1L*diff*diff*(len-t);
                }
                k=0;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        long res =minSumSquareDiff(new int[]{10,10,10,11,5},new int[]{1,0,6,6,1},11,27);
        System.out.println(res);
    }
}
