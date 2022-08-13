package leetcode.BFSDFS;
import java.util.*;
public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer,List<Integer>> parent = new HashMap<>();
        for(int[] arr:edges){
            List<Integer> list = parent.getOrDefault(arr[0],new ArrayList<>());
            list.add(arr[1]);
            parent.put(arr[0],list);
            List<Integer> list2 = parent.getOrDefault(arr[1],new ArrayList<>());
            list2.add(arr[0]);
            parent.put(arr[1],list2);
        }
        Set<Integer> set = new HashSet<>();
        for(int i:restricted){
            set.add(i);
        }
        return getCount(0,set,parent);
    }
    public int getCount(int node, Set<Integer> memo, Map<Integer,List<Integer>> map){
        if(memo.contains(node)){
            return 0;
        }
        memo.add(node);
        int count =1;
        if(map.containsKey(node)){
            List<Integer> child = map.get(node);
            for(int i:child){
                count+=getCount(i,memo,map);
            }
        }
        return count;
    }
}
