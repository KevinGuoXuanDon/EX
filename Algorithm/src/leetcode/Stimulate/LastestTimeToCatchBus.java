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

    public static void main(String[] args) {
        LastestTimeToCatchBus l = new LastestTimeToCatchBus();
        int res =l.latestTimeCatchTheBus(new int[]{10,20,30},new int[]{4,11,13,19,21,25,26},2);
        System.out.println(res);
    }
}
