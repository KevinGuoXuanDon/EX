package leetcode.Stimulate;
import java.util.*;
public class LastestTimeToCatchBus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int idx=0;
        for(int i:buses){
            List<Integer> list = new ArrayList<>();
            while(idx<passengers.length && passengers[idx]<=i){
                list.add(passengers[idx]);
                idx++;
            }
            map.put(i,list);
        }
        int res =0;
        for(int i: map.keySet()){
            List<Integer> temp = map.get(i);
            if(temp.size()<capacity) res=Math.max(res,i);
            else{
                int num = temp.get(capacity);
                while(temp.contains(num)){
                    num--;
                }
                res = Math.max(res,num);
            }
        }
        return res;
    }

    /**
     * 赛后看了看，发现理解错了题目意思。
     * 上一趟车没上去的人依旧可以在下一趟车上，所以不需要按车次把人分成几段
     * 如果最后一班公交还有空位，我们可以在发车时到达公交站，如果此刻有人，我们可以顺着他往前找到没人到达的时刻；
     * 如果最后一班公交没有空位，我们可以找到上一个上车的乘客，顺着他往前找到一个没人到达的时刻。
     */
    public int lastTimeCatchTheBus(int[] buses, int[] passengers, int capacity){
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int res = 0;
        for(int i=0,j=0;i<buses.length;i++){
            int cap = capacity;
            while(cap>0 && j<passengers.length && passengers[j]<=buses[i]){
                if(j==0 || ( j>0 && passengers[j]-1!=passengers[j-1])){
                    res = Math.max(res,passengers[j]-1);
                }
                cap--;
                j++;
            }
            if(cap>0){
                if(j==0 || (j>0 && passengers[j-1]!=buses[i])){
                    res = Math.max(res,buses[i]);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        LastestTimeToCatchBus l = new LastestTimeToCatchBus();
        int res =l.latestTimeCatchTheBus(new int[]{10,20,30},new int[]{4,11,13,19,21,25,26},2);
        System.out.println(res);
    }
}
