package leetcode.Hash;
import java.util.*;
public class GoupPeopleGivenGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res =new LinkedList<>();
        for(int i=0; i<groupSizes.length;i++){
            int value = groupSizes[i];
            List<Integer> temp = map.getOrDefault(value,new ArrayList<>());
            temp.add(i);
            map.put(value,temp);
        }
        for (int k : map.keySet()) {
            List<Integer> list = map.get(k), cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                cur.add(list.get(i));
                if (cur.size() == k) {
                    res.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }

        for(int i:map.keySet()){
            List<Integer> temp = map.get(i);
            while(temp.size()/i>1){
                List<Integer> list = new ArrayList<>();
                for(int count=0; count<i; count++){
                    list.add(temp.get(0));
                    temp.remove(0);
                }
                res.add(list);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
